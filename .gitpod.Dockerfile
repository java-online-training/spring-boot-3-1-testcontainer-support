FROM gitpod/workspace-full

SHELL ["/bin/bash", "-c"]
RUN source "/home/gitpod/.sdkman/bin/sdkman-init.sh"  \
    && sdk install java 20.0.1-amzn < /dev/null