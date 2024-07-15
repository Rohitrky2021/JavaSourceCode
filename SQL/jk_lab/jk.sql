clc;
clear all;
close all;
t=0:0.01:3;
a=sin(2*pi*t);
p=square(2*pi*10*t);
p(p<0)=0;

s=a.*p;

subpot(3,1,1);

plot(t,a);
xlabel('time');

y label('amplitude');

title('message signal');



Subplot(3,2,1);
plot(t,p);
xlabel('time');
ylabel('amplitude');
title('carrier signal ');
subplot (3,1,3);
plot (t,s);
xlabel('time');
ylabel('amplitude');
title('natural smapling');

y = unicodce (5,3,1);
subplot (4,1,4);

plot(t,y);

xlabel('time');
ylabel('amplitude');
tile ('flat top scaling ');