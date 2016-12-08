# Database Exercise
# Use SOURCE command to run this script

DROP DATABASE GAME;
CREATE DATABASE GAME;
USE GAME;

CREATE TABLE BINGO (
ID VARCHAR (5),
QUESTION VARCHAR (1000),
ANSWER VARCHAR (100)
);


INSERT INTO BINGO VALUES ('1', '  ___________ is connect networks and forward/route 
packets', 'router');
INSERT INTO BINGO VALUES ('2', ' ___________defines format, order of msgs sent and 
received among network entities, 
and actions taken on msg transmission, receipt', 'protocol');
INSERT INTO BINGO VALUES ('3', ' <Internet protocol stack>    application layer 
-  ________________ 
- __________________ 
- link layer', 'transport layer, network layer');
INSERT INTO BINGO VALUES ('4', '__________ is global address (e.g.169.34.11.56)', 'IP address');
INSERT INTO BINGO VALUES ('5', 'IP address is ____bit', '32');
INSERT INTO BINGO VALUES ('6', 'Each end-end data stream divided into__________', 'packet');
INSERT INTO BINGO VALUES ('7', '______________________is a method In packet 
switching. Entire packet must arrive at router 
before it can be transmitted on next link', 'store and forward');
INSERT INTO BINGO VALUES ('8', 'If there are 3 hops, L =7.5 Mbits R = 1.5 Mbps.
Delay is _________sec', '15');
INSERT INTO BINGO VALUES ('9', '_______________ : packets can be dropped if memory
(buffer) fills up', 'loss');
INSERT INTO BINGO VALUES ('10', '______________ delay is Time for router to push 
out the packet. function of packet¡¯s length 
(L bits) and transmission rate(R bps) of link .', 'Transmission');
INSERT INTO BINGO VALUES ('11', 'In p2p, why sever is safe when client are 
increasing', 'self scalability');
INSERT INTO BINGO VALUES ('12', 'Process sends/receives messages to/from its
 ___________. It is a software interface 
between the application layer and transport
-layer protocol.', 'socket');
INSERT INTO BINGO VALUES ('13', 'Identifier includes both _____address and
 __________________ associated with process on host.', 'IP,port number');
INSERT INTO BINGO VALUES ('14', 'What is the port number of HTTP server?', '80');
INSERT INTO BINGO VALUES ('15', 'What is the port number of mail server?', '25');
INSERT INTO BINGO VALUES ('16', 'Select-(TCP/UDP) reliable transport between
sending and receiving process .It is 
connection-oriented: setup required between 
client and server processes.', 'TCP');
INSERT INTO BINGO VALUES ('17', 'Select-(TCP/UDP) unreliable data transfer 
between sending and receiving process. It does 
not provide: reliability, or connection setup.', 'UDP');
INSERT INTO BINGO VALUES ('18', 'Underlying transport protocol of email 
is ____________.', 'TCP');
INSERT INTO BINGO VALUES ('19', 'HTTP:Hypertext _ _ _ _ _ _ _ _ 
  _ _ _ _ _ _ _ _.', 'transfer,protocol');
INSERT INTO BINGO VALUES ('20', 'RTT:_ _ _ _ _ Trip _ _ _ _ ', 'round, time');
INSERT INTO BINGO VALUES ('21', 'Select-(non-persistent HTTP / persistent HTTP) 
:server leaves connection open after sending 
response', 'persistent HTTP');
INSERT INTO BINGO VALUES ('22', 'What is the name of frame in transport-layer',  'segment');
INSERT INTO BINGO VALUES ('23', 'What is the name of frame in network-layer',  'datagram');
INSERT INTO BINGO VALUES ('24', 'Transport layer: logical communication 
between ______________', 'processes');
INSERT INTO BINGO VALUES ('25', 'Network layer: logical communication
between ______________', 'hosts');
INSERT INTO BINGO VALUES ('26', 'In UDP,_______________ detects errors in 
transmitted segment', 'checksum');
INSERT INTO BINGO VALUES ('27', 'A method by which multiple data streams are
combined into one stream/signal over a shared 
logical/physical communication link', 'multiplexing');
INSERT INTO BINGO VALUES ('28', 'What is difference between router and switch
except Optimal routing', 'plug and play');
INSERT INTO BINGO VALUES ('29', 'Each ___________ has a 48-bit unique identifier
 assigned by its manufacturer', 'NIC');
INSERT INTO BINGO VALUES ('30', 'If host A wants to send datagram to host B. 
B¡¯s MAC address not in A¡¯s ARP table. 
Host A ________________ ARP query packet', 'broadcast');
INSERT INTO BINGO VALUES ('31', 'What is the broadcast MAC address
 ( ___-___-___-___-___-___ )?', 'FF-FF-FF-FF-FF-FF');
INSERT INTO BINGO VALUES ('32', 'If cwnd value before timeout is 12.
 What is ssthresh?', '6');


COMMIT;