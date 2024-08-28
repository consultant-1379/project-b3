-- CREATE DATABASE cloud_native;

USE cloud_native;

CREATE TABLE stage(
STAGE_ID INT NOT NULL AUTO_INCREMENT,
STAGE_NAME VARCHAR(30) NOT NULL,
PRIMARY KEY (STAGE_ID)
);

CREATE TABLE leading_questions(
LEADING_QUESTION_ID INT NOT NULL AUTO_INCREMENT,
STAGE_ID INT NOT NULL,
DESCRIPTION VARCHAR(255) NOT NULL,
PRIMARY KEY (LEADING_QUESTION_ID),
FOREIGN KEY (STAGE_ID)
REFERENCES stage(STAGE_ID)
);

CREATE TABLE sub_questions(
SUB_QUESTION_ID INT NOT NULL AUTO_INCREMENT,
STAGE_ID INT NOT NULL,
DESCRIPTION VARCHAR(255) NOT NULL,
PRIMARY KEY (SUB_QUESTION_ID),
FOREIGN KEY (STAGE_ID)
REFERENCES stage(STAGE_ID)
);

CREATE TABLE response_options(
OPTIONS_ID INT NOT NULL AUTO_INCREMENT,
OPTION_DESC VARCHAR(30) NOT NULL,
PRIMARY KEY (OPTIONS_ID)
);

CREATE TABLE survey_user(
USER_ID INT NOT NULL AUTO_INCREMENT,
USER_NAME VARCHAR(30) NOT NULL,
USER_EMAIL VARCHAR(30) NOT NULL,
PRIMARY KEY (USER_ID)
);

CREATE TABLE survey_response(
SURVEY_RESPONSE_ID INT NOT NULL AUTO_INCREMENT,
USER_ID INT NOT NULL,
SUB_QUESTION_ID INT NOT NULL,
LEADING_QUESTION_ID INT NOT NULL,
STAGE_ID INT NOT NULL,
OPTIONS_ID INT NOT NULL,
PRIMARY KEY (SURVEY_RESPONSE_ID),
FOREIGN KEY (USER_ID)
REFERENCES survey_user(USER_ID),
FOREIGN KEY (SUB_QUESTION_ID)
REFERENCES sub_questions(SUB_QUESTION_ID),
FOREIGN KEY (LEADING_QUESTION_ID)
REFERENCES leading_questions(LEADING_QUESTION_ID),
FOREIGN KEY (STAGE_ID)
REFERENCES stage(STAGE_ID),
FOREIGN KEY (OPTIONS_ID)
REFERENCES response_options(OPTIONS_ID)
);

INSERT INTO stage (STAGE_NAME) VALUES ('Culture');
INSERT INTO stage (STAGE_NAME) VALUES ('Prod/Design Service');
INSERT INTO stage (STAGE_NAME) VALUES ('Team');
INSERT INTO stage (STAGE_NAME) VALUES ('Process');
INSERT INTO stage (STAGE_NAME) VALUES ('Architecture');
INSERT INTO stage (STAGE_NAME) VALUES ('Maintenance');
INSERT INTO stage (STAGE_NAME) VALUES ('Delivery');
INSERT INTO stage (STAGE_NAME) VALUES ('Provisioning');
INSERT INTO stage (STAGE_NAME) VALUES ('Infrastructure');

INSERT INTO response_options (OPTION_DESC) VALUES ('Yes');
INSERT INTO response_options (OPTION_DESC) VALUES ('No');

INSERT INTO leading_questions (STAGE_ID,DESCRIPTION) VALUES(1,"Do you have a collaborative culture");
INSERT INTO leading_questions (STAGE_ID,DESCRIPTION) VALUES(2,"Is your product design and data driven");
INSERT INTO leading_questions (STAGE_ID,DESCRIPTION) VALUES(3,"Are teams Devops teams that is self contained teams responsible for all development and deployment to production and production is monitored by SRE teams?"); 
INSERT INTO leading_questions (STAGE_ID,DESCRIPTION) VALUES(4,"Do you use research and experimentation techniques for large and complex problems - using lots of proof of concepts to compare options, using Kanban to clarify the project then Agile methods like Scrum once problem is well understood?");
INSERT INTO leading_questions (STAGE_ID,DESCRIPTION) VALUES(5,"Do you have a microprocessor architecture built from independently deployable services?");
INSERT INTO leading_questions (STAGE_ID,DESCRIPTION) VALUES(6,"Does your system collect metrics, alerts tracing and logging to provide a view of the running system and try to keep itself alive through seldf healing if things begin to deteriorate?");
INSERT INTO leading_questions (STAGE_ID,DESCRIPTION) VALUES(7,"Do you deliver multiple times a day your releasable software?");
INSERT INTO leading_questions (STAGE_ID,DESCRIPTION) VALUES(8,"Do you run on Kubernetes?");
INSERT INTO leading_questions (STAGE_ID,DESCRIPTION) VALUES(9,"Do you deploy your software in containers?");


INSERT INTO sub_questions (STAGE_ID,DESCRIPTION) VALUES(1,"Project managers coordinate between all the different teams working on the same project, and the teams have highly specialised responsibilities");
INSERT INTO sub_questions (STAGE_ID,DESCRIPTION) VALUES(1,"Our development teams focus on achieving small, defined objectives quickly and then moving immediately to the next one");
INSERT INTO sub_questions (STAGE_ID,DESCRIPTION) VALUES(1,"A lot of up-front planning goes into documenting each step of a project before it even begins");
INSERT INTO sub_questions (STAGE_ID,DESCRIPTION) VALUES(1,"Each team contain a mix of members whose different areas of expertise cover the full spectrum of skills needed for crafting a releasable increment");

INSERT INTO sub_questions (STAGE_ID,DESCRIPTION) VALUES(2,"We have product roadmaps spanning months or even years into the future. Our releases typically happen every six months to one year, sometimes even longer");
INSERT INTO sub_questions (STAGE_ID,DESCRIPTION) VALUES(2,"There is pressure to deliver features, fast, and releases happen on a regular planned basis.");
INSERT INTO sub_questions (STAGE_ID,DESCRIPTION) VALUES(2,"We release large sets of related features all at once as comprehensive updates");
INSERT INTO sub_questions (STAGE_ID,DESCRIPTION) VALUES(2,"Our releases are usually small-scale iterative changes to existing features/services");

INSERT INTO sub_questions (STAGE_ID,DESCRIPTION) VALUES(3,"All decisions are made by managers, and teams must seek permission before changing any part of the project plan, no matter how small");
INSERT INTO sub_questions (STAGE_ID,DESCRIPTION) VALUES(3,"Applications are developed as several large components, with one team per component fully and vertically responsible for the build");
INSERT INTO sub_questions (STAGE_ID,DESCRIPTION) VALUES(3,"We have separate teams of specialists to handle different areas: design, architecture, security, testing, etc. When our team's piece of a project is finished, we hand it off to the next team");
INSERT INTO sub_questions (STAGE_ID,DESCRIPTION) VALUES(3,"Our teams are mixed: We have developers, QA/testing, someone with server experience, etc. all in one group. We don't talk to other teams very much since our teams are meant to be self-sufficient and independent");

INSERT INTO sub_questions (STAGE_ID,DESCRIPTION) VALUES(4,"We do all our planning up front, and then hand off to teams for execution. Managers handle the collaboration and communication between our teams");
INSERT INTO sub_questions (STAGE_ID,DESCRIPTION) VALUES(4,"A team will work on one small, defined project and deliver it in two to four weeks. If a new feature request comes in the middle of a delivery cycle, we may or may not be able to add it in");
INSERT INTO sub_questions (STAGE_ID,DESCRIPTION) VALUES(4,"If a new feature request comes in the middle of a delivery cycle, we have to wait for the next cycle to plan for and incorporate it");
INSERT INTO sub_questions (STAGE_ID,DESCRIPTION) VALUES(4,"If we can't coordinate or fix an issue on the last day or two of a production cycle, we can't ship so when a bug or some other problem pops up it's hard to do anything more than a quick fix.");


INSERT INTO sub_questions (STAGE_ID,DESCRIPTION) VALUES(5,"Our system is very big. Few people understand the whole thing. We fear the domino effect: If you change something, you have to be very careful because it could break something else");
INSERT INTO sub_questions (STAGE_ID,DESCRIPTION) VALUES(5,"Our application/s is/are divided into components, probably no more than five or six, communicating through networking");
INSERT INTO sub_questions (STAGE_ID,DESCRIPTION) VALUES(5,"When we deliver, everything is delivered together, all ready on the same day and at a uniformly high level of quality");
INSERT INTO sub_questions (STAGE_ID,DESCRIPTION) VALUES(5,"The scope of an app in development is defined by the deployment schedule. Each feature or piece of functionality is broken down into deliverable chunks that fit into the schedule");


INSERT INTO sub_questions (STAGE_ID,DESCRIPTION) VALUES(6,"We have some simple automation, like scripts, for alerting large-scale issues and outages in the field. We find out about many smaller problems from user reports");
INSERT INTO sub_questions (STAGE_ID,DESCRIPTION) VALUES(6,"Our systems have full and continuous monitoring, and our Ops team spends lots of time checking on alerts. A lot of time, our system alerts turn out to be nothing");
INSERT INTO sub_questions (STAGE_ID,DESCRIPTION) VALUES(6,"When problems arise, we have to open each server to understand what happened because we don't have central logs or tracing. Then we fix it manually: someone from Operations logs into a production server and follows a preset procedure.");
INSERT INTO sub_questions (STAGE_ID,DESCRIPTION) VALUES(6,"Some of our system update processes are fully automated and patches can be applied quickly but a human still has to initialise the process");

INSERT INTO sub_questions (STAGE_ID,DESCRIPTION) VALUES(7,"We do 'big bang' releases that roll lots of changes into one new version, every six to 12 months. A lot of up-front planning goes into our next release before any actual development begins");
INSERT INTO sub_questions (STAGE_ID,DESCRIPTION) VALUES(7,"Our delivery process includes some test automation and automated build, but outside of final integration. In an emergency, we can make manual updates to the production codebase");
INSERT INTO sub_questions (STAGE_ID,DESCRIPTION) VALUES(7,"We don't like to make changes to our production code, even emergency ones, because there are so many dependencies. Change is risky. Once we release a software version all changes have to wait for the next version roll out.");
INSERT INTO sub_questions (STAGE_ID,DESCRIPTION) VALUES(7,"New functionality requests typically can be accommodated within a few weeks, if they are urgent");


INSERT INTO sub_questions (STAGE_ID,DESCRIPTION) VALUES(8,"Operations team is in charge of provisioning, period. You have to write a ticket to provision a machine engineers can't self-service.");
INSERT INTO sub_questions (STAGE_ID,DESCRIPTION) VALUES(8,"A machine can be provisioned possibly even auto provisioned in hours, or maybe a day or two, and the process is fully automated by Ops");
INSERT INTO sub_questions (STAGE_ID,DESCRIPTION) VALUES(8,"Developers write applications, and specify what they will need to run successfully in production (OS, libraries, dependent tools). The Ops team manually configures the production machines to meet the machine dependencies the Dev team specified");
INSERT INTO sub_questions (STAGE_ID,DESCRIPTION) VALUES(8,"Provisioning is a mix of automation and manual work.  Any task taking longer than a week to provision to VM breaks the production cycle, so is a nonstarter");


INSERT INTO sub_questions (STAGE_ID,DESCRIPTION) VALUES(9,"We have multiple physical servers in our own private data center (either on premises or co-located). If one of our servers goes down, we have to manually provision its replacement.");
INSERT INTO sub_questions (STAGE_ID,DESCRIPTION) VALUES(9,"We don't use physical servers, we have VMs. We also have some instances in the cloud, which we manage manually.");
INSERT INTO sub_questions (STAGE_ID,DESCRIPTION) VALUES(9,"A data centre failure is just about the worst disaster we can imagine");
INSERT INTO sub_questions (STAGE_ID,DESCRIPTION) VALUES(9,"Provisioning infrastructure is a mix of automation and manual work, so a new VM can take a couple of days to set up.");