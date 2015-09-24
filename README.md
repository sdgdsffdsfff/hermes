# Hermes 
[![Build Status](https://travis-ci.org/ctripcorp/hermes.svg?branch=master)](https://travis-ci.org/ctripcorp/hermes)
[![GitHub release](https://img.shields.io/github/release/ctripcorp/hermes.svg)](https://github.com/ctripcorp/hermes/releases)
[![Coverage Status](https://coveralls.io/repos/ctripcorp/hermes/badge.svg?branch=master&service=github)](https://coveralls.io/github/ctripcorp/hermes?branch=master)


Ctrip asynchronous message queue solution


携程异步消息系统实践

消息队列是一种广泛使用的异步通讯机制，使用消息队列往往可以获得更加健壮和可维护的系统。Hermes是携程新一代的消息队列系统，它的设计特点是简单、高效、扩展性以及完善的监控，可应用在高吞吐、高可靠等多样的业务场景之下。本次演讲将会从两个角度来分享消息系统，一是从消息系统自身的开发者角度介绍构建消息系统需要解决的核心问题(可用性、吞吐量、传输延迟、有序消息、消息存储、过滤、重发等)、Hermes的整体架构设计及存储演变(brokerless->master-slave brokers->clustered brokers，MongoDB->MySQL+File)以及与常见消息系统的比较等。二是从消息系统使用者的角度分享如何使用好消息系统、有哪些典型的应用场景以及在携程的应用推广情况等。
