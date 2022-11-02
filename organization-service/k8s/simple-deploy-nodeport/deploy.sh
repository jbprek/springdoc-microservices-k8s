#!/bin/sh
# Create Namespace
kubectl create ns oe
# Create Config Maps
kubectl -n oe create cm employee-service-cm --from-file=employee-service/application.yml -n oe
kubectl -n oe create cm organization-service-cm --from-file=organization-service/application.yml

# Create Deployments
#  Created with kubectl create deployment employee-service-deploy --image=localhost:5000/employee-service:1.0.0 --port=8080 -n oe --dry-run=client -o yaml > employee-service-deploy.yml
cat <<EOF >employee-service-deploy.yml
apiVersion: apps/v1
kind: Deployment
metadata:
  creationTimestamp: null
  labels:
    app: employee-service-deploy
  name: employee-service-deploy
  namespace: oe
spec:
  replicas: 1
  selector:
    matchLabels:
      app: employee-service-deploy
  strategy: {}
  template:
    metadata:
      creationTimestamp: null
      labels:
        app: employee-service-deploy
    spec:
      containers:
      - image: localhost:5000/employee-service:1.0.0
        name: employee-service
        ports:
        - containerPort: 8080
        volumeMounts:
        - name: config-volume
          mountPath: /workspace/config
        resources: {}
      volumes:
      - name: config-volume
        configMap:
          name: employee-service-cm
status: {}
EOF

kubectl apply -f employee-service-deploy.yml

kubectl create deployment organization-service-deploy --image=localhost:5000/organization-service:1.0.0 --port=8080 -n oe


# Create Services
kubectl
kubectl expose deployment employee-service-deploy --name=employee-service \
--port=80 --target-port=8080 \
--type=NodePort
kubectl expose deployment organization-service-deploy  --name=organization-service \
--port=80 --target-port=8080 \
--type=NodePort

echo 'Edit services to set to the desired nodePort'