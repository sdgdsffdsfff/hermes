package com.ctrip.hermes.metaserver.rest.resource;

import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unidal.dal.jdbc.DalException;

import com.alibaba.fastjson.JSON;
import com.ctrip.hermes.core.bo.SubscriptionView;
import com.ctrip.hermes.core.utils.PlexusComponentLocator;
import com.ctrip.hermes.metaservice.service.SubscriptionService;
import com.ctrip.hermes.metaservice.service.SubscriptionService.SubscriptionStatus;

@Path("/subscriptions/")
@Singleton
@Produces(MediaType.APPLICATION_JSON)
public class SubscriptionsResource {

	private static final Logger logger = LoggerFactory.getLogger(SubscriptionsResource.class);

	private SubscriptionService subscriptionService = PlexusComponentLocator.lookup(SubscriptionService.class);

	@Path("/")
	@GET
	public List<SubscriptionView> getAll() {
		try {
			return subscriptionService.getSubscriptions();
		} catch (DalException e) {
			throw new InternalServerErrorException(e);
		}
	}

	@Path("RUNNING")
	@GET
	public List<SubscriptionView> getRunning() {
		try {
			return subscriptionService.getSubscriptions(SubscriptionStatus.RUNNING);
		} catch (DalException e) {
			throw new InternalServerErrorException(e);
		}
	}

	@Path("STOPPED")
	@GET
	public List<SubscriptionView> getStopped() {
		try {
			return subscriptionService.getSubscriptions(SubscriptionStatus.STOPPED);
		} catch (DalException e) {
			throw new InternalServerErrorException(e);
		}
	}

	@Path("/")
	@POST
	public Response subscribe(String content) {
		logger.debug("subscribe {}", content);

		SubscriptionView subscription = null;
		try {
			subscription = JSON.parseObject(content, SubscriptionView.class);
		} catch (Exception e) {
			throw new BadRequestException("Parse subscription failed", e);
		}

		try {
			subscription = subscriptionService.create(subscription);
		} catch (Exception e) {
			throw new InternalServerErrorException(e);
		}

		return Response.status(Status.CREATED).entity(subscription).build();
	}

	@Path("{id}")
	@DELETE
	public Response unsubscribe(@PathParam("id") long id) {
		logger.debug("unsubscribe {}", id);

		try {
			subscriptionService.remove(id);
		} catch (Exception e) {
			throw new InternalServerErrorException(e);
		}

		return Response.status(Status.OK).build();
	}

	@Path("{id}/start")
	@PUT
	public Response start(@PathParam("id") long id) {
		logger.debug("start {}", id);

		try {
			subscriptionService.start(id);
		} catch (Exception e) {
			throw new InternalServerErrorException(e);
		}

		return Response.status(Status.OK).build();
	}

	@Path("{id}/stop")
	@PUT
	public Response stop(@PathParam("id") long id) {
		logger.debug("stop {}", id);

		try {
			subscriptionService.stop(id);
		} catch (Exception e) {
			throw new InternalServerErrorException(e);
		}

		return Response.status(Status.OK).build();
	}
}
