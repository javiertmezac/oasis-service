#!/bin/bash

# 1. mvn package
# 2. docker build with tag
# 3. docker tag
# 4. login
# 5. docker push with tag
  #251143205581.dkr.ecr.us-west-1.amazonaws.com/oasis-service:0.1.0-beta

tag=$1
ECR_REPO="251143205581.dkr.ecr.us-west-1.amazonaws.com"
IMAGE_TAGGED=$ECR_REPO"/oasis-service":$tag

if [[ -z "$tag" ]]; then
  echo "please specify tag version"
  exit 1
fi

echo "tag to be used: $tag"

#cd ../
pwd
mvn clean package

echo
echo "BUILDING IMAGE......"
docker build -t oasis-service-image:$tag .

echo
echo "TAGGING IMAGE......"
docker tag oasis-service-image:$tag $IMAGE_TAGGED

echo "IMAGE TAGGED.... SEARCHING IMAGE!!"
docker images | grep $ECR_REPO"/oasis-service"

echo
echo "Would you like to continue pushing the image? [Y/N]"
read varanswer

if [[ "$varanswer" == "Y" ]]; then
  echo "LOGGING INTO PUBLIC REPO...."
  aws ecr get-login-password \
    --region us-west-1 --profile javier.meza | docker login --username AWS --password-stdin $ECR_REPO

  echo
  echo "PUSHING IMAGE.... $IMAGE_TAGGED"
  docker push $IMAGE_TAGGED
else
  echo "CANCELING PUSH OF IMAGE $IMAGE_TAGGED"
  echo "bye.....!"
  exit 1
fi
