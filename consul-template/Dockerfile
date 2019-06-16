FROM docker:18.06.3
MAINTAINER Albert van t Hart <avthart@gmail.com>

ENV CONSUL_TEMPLATE_VERSION 0.20.0
ENV APACHE_IMAGE_NAME lzrbear/docker-apache2-ubuntu:16.04


ADD https://releases.hashicorp.com/consul-template/${CONSUL_TEMPLATE_VERSION}/consul-template_${CONSUL_TEMPLATE_VERSION}_SHA256SUMS /tmp/
ADD https://releases.hashicorp.com/consul-template/${CONSUL_TEMPLATE_VERSION}/consul-template_${CONSUL_TEMPLATE_VERSION}_linux_amd64.zip /tmp/
COPY sites-available /etc/apache2/sites-available
COPY reload-apache2 /bin

RUN chmod +x /bin/reload-apache2

RUN cd /tmp && \
    sha256sum -c consul-template_${CONSUL_TEMPLATE_VERSION}_SHA256SUMS 2>&1 | grep OK && \
    unzip consul-template_${CONSUL_TEMPLATE_VERSION}_linux_amd64.zip && \
    mv consul-template /bin/consul-template && \
    rm -rf /tmp && \
    apk --update add curl bash

WORKDIR /etc/ctmpl

COPY ctmpl /etc/ctmpl

ENTRYPOINT ["/bin/consul-template"]