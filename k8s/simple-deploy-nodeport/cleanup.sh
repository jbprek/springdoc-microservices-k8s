#!/bin/sh
# Delete  Config Maps
kubectl delete cm employee-service-cm -n oe
kubectl delete cm organization-service-cm -n oe

# Delete Deployments
kubectl delete deployment employee-service-deploy -n oe
kubectl delete deployment organization-service-deploy -n oe


# Delete Services
kubectl delete service employee-service -n oe
kubectl delete service organization-service -n oe

# Delete namespace
kubectl delete ns oe

