FROM node:26-alpine AS base

RUN <<EOF
set -e

npm install -g corepack
corepack enable
EOF

ARG DOCKER_UID=1000
ARG DOCKER_GID=1000
RUN <<EOF

deluser node
addgroup -S node -g $DOCKER_GID
adduser -S -G node -u $DOCKER_UID
chown -R node:node /home/node
EOF

USER node
WORKDIR /var/www/html

COPY --link --from=nuxt package.json /var/www/html/package.json
RUN ["corepack", "install"]

FROM base AS develop

USER root
RUN apk add --no-cache bash
USER node

EXPOSE 3000
STOPSIGNAL SIGKILL

CMD ["sleep", "infinity"]

FROM base AS build

COPY --link --from=nuxt --chown=node:node ./package.json /var/www/html/
COPY --link --from=nuxt --chown=node:node ./pnpm-lock.json /var/www/html/
RUN pnpm install --prod --frozen-lockfile

COPY --link --from=nuxt --chown=node:node . /var/www/html
RUN pnpm run generate