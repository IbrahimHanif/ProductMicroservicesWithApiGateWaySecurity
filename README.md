"# ProductMicroservicesWithApiGateWaySecurity" 

1. Install docker 

2. Install erlang 

3. Install RabbitMQ using docker
    docker run -d -p 15672:15672 -p 5672:5672 --name rabbitmq-master rabbitmq:3-management
    copy and paste the following URL in the brower to check the RabbitMQ installaion status.
     http://localhost:15672/#/

4. execute the following comment in the command prompt 
   set RABBIT_URI=amqp://localhost

5. Install zipkin through docker
   docker run -d -p 9411:9411 openzipkin/zipkin
   copy and paste the following URL in the brower to check the zipkin  installaion status.
   http://localhost:9411/zipkin/
   
