FROM nginx:latest

COPY build/docs/asciidoc /usr/share/nginx/html

LABEL org.opencontainers.image.source https://github.com/felipeg48/rabbitmq-beginner-lesson

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]