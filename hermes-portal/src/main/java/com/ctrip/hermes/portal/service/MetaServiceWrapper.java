package com.ctrip.hermes.portal.service;

import java.util.List;
import java.util.Map;

import com.ctrip.hermes.meta.entity.Codec;
import com.ctrip.hermes.meta.entity.Datasource;
import com.ctrip.hermes.meta.entity.Endpoint;
import com.ctrip.hermes.meta.entity.Meta;
import com.ctrip.hermes.meta.entity.Partition;
import com.ctrip.hermes.meta.entity.Server;
import com.ctrip.hermes.meta.entity.Storage;
import com.ctrip.hermes.meta.entity.Topic;
import com.ctrip.hermes.metaservice.service.MetaService;

public interface MetaServiceWrapper extends MetaService {
	public Storage findStorage(String topic);

	public Topic findTopic(long id);

	public Topic findTopicByName(String name);

	public List<Topic> findTopicsByPattern(String pattern);

	public Codec getCodecByTopic(String topic);

	public Codec getCodecByType(String type);

	public Map<String, Codec> getCodecs();

	public Meta getMeta();

	public List<Partition> getPartitions(String topic);

	public Map<String, Storage> getStorages();

	public List<Server> getServers();

	public Endpoint getEndpoint(String endpointId);

	public Datasource getDatasource(String storageType, String datasourceId);
}
