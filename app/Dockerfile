FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
RUN addgroup -S appgroup && \
    adduser -S appuser -G appgroup
COPY target/*.jar app.jar
USER appuser
EXPOSE 8080
HEALTHCHECK --interval=30s --timeout=3s \
  CMD wget -q --spider \
  http://localhost:8080/api/payments/health || exit 1
ENTRYPOINT ["java", "-jar", "app.jar"]