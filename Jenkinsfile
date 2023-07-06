pipeline {
    agent any

    stages{
        stage('拉取代码'){
            steps{
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'pwd', url: 'https://github.com/Zealw/zeal.git']])            }
        }
        stage('编译代码'){
            steps{
                sh "/usr/local/apache-maven-3.9.2/bin/mvn clean install"
                sh "cd /var/jenkins_home/workspace/zeal && /usr/local/apache-maven-3.9.2/bin/mvn package -Dmaven.test.skip=true"
            }
        }
        stage('打包代码'){
            steps{
                sh '''
                JENKINS_JAR_HOME='/var/jenkins_home/workspace/zeal/target'
                DOCKERFILE_HOME='/var/jenkins_home/workspace/zeal'
                HARBOR_IP='registry.cn-hangzhou.aliyuncs.com'
                REPOSITORIES='zealuu/zeal'
                HARBOR_USER='zealuu'
                PASSWORD='zealuu9.'
                DOCKER_NAME='zeal'
                sudo docker login -u ${HARBOR_USER} -p ${PASSWORD} ${HARBOR_IP}

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
                    sudo docker rmi ${IMAGE_ID}
                fi

                cd ${DOCKERFILE_HOME}
                pwd

                sudo docker build --no-cache -t ${HARBOR_IP}/${REPOSITORIES}:last --no-cache .

                '''

            }
        }
        stage('部署代码') {
            agent none
                steps {
                    script{
                    sh '''
                    HARBOR_IP='registry.cn-hangzhou.aliyuncs.com'
                    REPOSITORIES='zealuu/zeal'
                    HARBOR_USER='zealuu'
                    DOCKER_NAME='zeal'
                    PASSWORD='zealuu9.'

                    sudo docker login -u ${HARBOR_USER} -p ${PASSWORD} ${HARBOR_IP}

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

                    sudo docker pull ${HARBOR_IP}/${REPOSITORIES}:last &>/dev/null

                    sudo docker run -d -p 9639:9639 --name ${DOCKER_NAME} ${HARBOR_IP}/${REPOSITORIES}:last
                    '''
                }
            }
        }
    }
}