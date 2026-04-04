#!/bin/bash

echo "🔍 Checking Jenkins pod..."
kubectl get pods -n jenkins

echo "🔗 Starting port-forward..."
pkill -f "port-forward svc/jenkins" 2>/dev/null || true
sleep 2

kubectl port-forward svc/jenkins 8080:8080 -n jenkins &
sleep 3

echo "✅ Jenkins available at: http://localhost:8080"
echo "Username: admin"
echo "Password: $(kubectl exec --namespace jenkins -it svc/jenkins \
  -c jenkins -- /bin/cat /run/secrets/additional/chart-admin-password 2>/dev/null)"