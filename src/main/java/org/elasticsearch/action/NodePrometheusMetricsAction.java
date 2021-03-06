/*
 * Copyright [2016] [Vincent VAN HOLLEBEKE]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.elasticsearch.action;

import org.elasticsearch.client.ElasticsearchClient;
import org.elasticsearch.common.io.stream.Writeable;

/**
 * Action class for Prometheus Exporter plugin.
 */
public class NodePrometheusMetricsAction extends Action<NodePrometheusMetricsRequest, NodePrometheusMetricsResponse,
        NodePrometheusRequestBuilder> {
    public static final NodePrometheusMetricsAction INSTANCE = new NodePrometheusMetricsAction();
    public static final String NAME = "cluster:monitor/prometheus/metrics";

    private NodePrometheusMetricsAction() {
        super(NAME);
    }

    @Override
    @SuppressWarnings("deprecation")
    public NodePrometheusMetricsResponse newResponse() {
        throw new UnsupportedOperationException("usage of Streamable is to be replaced by Writeable");
    }

    @Override
    public NodePrometheusRequestBuilder newRequestBuilder(ElasticsearchClient client) {
        return new NodePrometheusRequestBuilder(client, this);
    }

    @Override
    public Writeable.Reader<NodePrometheusMetricsResponse> getResponseReader() {
        return NodePrometheusMetricsResponse::new;
    }
}
