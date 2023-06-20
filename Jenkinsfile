pipeline {
    agent any

    stages{
        stage('拉取代码'){
            steps{
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'ff', url: 'git@github.com:Zealw/zeal.git']])
            }
        }
        stage('编译代码'){
            steps{
                sh "/usr/local/apache-maven-3.9.2/bin/mvn clean install"
                sh "cd /home/app/jenkins/workspace/zeal && /usr/local/apache-maven-3.9.2/bin/mvn package -Dmaven.test.skip=true"
            }
        }
        stage('打包代码'){
            steps{
                sh '''
                JENKINS_JAR_HOME='/home/app/jenkins/workspace/zeal/target'
                DOCKERFILE_HOME='/home/app/jenkins/workspace/zeal'
                HARBOR_IP='registry.cn-hangzhou.aliyuncs.com'
                REPOSITORIES='zeal'
                HARBOR_USER='zealuu'

                sudo docker login -u ${HARBOR_USER} ${HARBOR_IP}
                IMAGE_ID=`sudo docker images | grep ${REPOSITORIES} | awk '{print $3}'`
                if [ -n "${IMAGE_ID}" ];then
                    sudo docker rmi ${IMAGE_ID}
                fi

                cd ${DOCKERFILE_HOME}
                pwd
                TAG=`date +%Y%m%d`
                sudo docker build --no-cache -t ${HARBOR_IP}/${REPOSITORIES}:${TAG} --no-cache .

                sudo docker push ${HARBOR_IP}:80/${REPOSITORIES}:${TAG}
                '''

            }
        }
        stage('部署代码') {
            agent none
                steps {
                    script{
                        def remote = [:]
                        remote.name = '47.93.85.151'
                        remote.host = '47.93.85.151'
                        remote.port = 22
                        remote.allowAnyHosts = true
                    sshCommand remote: remote, command: '''
                    HARBOR_IP='registry.cn-hangzhou.aliyuncs.com'
                    REPOSITORIES='zeal'
                    HARBOR_USER='zealuu'
                    DOCKER_NAME='zeal'

                    sudo docker login -u ${HARBOR_USER} ${HARBOR_IP}

                    CONTAINER_ID=`docker ps | grep ${DOCKER_NAME} | awk '{print $1}'`
                    if [ -n "$CONTAINER_ID" ]; then
                        docker stop $CONTAINER_ID
                        docker rm $CONTAINER_ID
                    else
                        CONTAINER_ID=`docker ps -a | grep ${DOCKER_NAME} | awk '{print $1}'`
                        if [ -n "$CONTAINER_ID" ]; then
                            docker rm $CONTAINER_ID
                        fi
                    fi

                    IMAGE_ID=`sudo docker images | grep ${REPOSITORIES} | awk '{print $3}'`
                    if [ -n "${IMAGE_ID}" ];then
                        docker rmi ${IMAGE_ID}
                    fi

                    TAG=`date +%Y%m%d`
                    sudo docker pull ${HARBOR_IP}/${REPOSITORIES}:${TAG} &>/dev/null

                    sudo docker run -d -p 9639:9639 --name ${DOCKER_NAME} ${HARBOR_IP}/${REPOSITORIES}:${TAG}
                    '''
                }
            }
        }
    }
}