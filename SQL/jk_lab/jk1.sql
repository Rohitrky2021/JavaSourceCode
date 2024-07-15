-- % Clear the command window, workspace, and close all open figures
clc;
clear all;
close all;

-- % Define the time vector from 0 to 3 seconds with a step of 0.01 seconds
t = 0:0.01:3;

-- % Generate a sine wave as the carrier signal
a = sin(2*pi*t);

-- % Generate a square wave modulated by the carrier signal
p = square(2*pi*10*t);
p(p < 0) = 0;  
--% Rectify the square wave to keep only the positive values

-- % Calculate the sampled signal using natural sampling
s = a .* p;

-- % Plot the message signal
subplot(3,1,1);
plot(t, a);
xlabel('Time');
ylabel('Amplitude');
title('Message Signal');

-- % Plot the carrier signal
subplot(3,1,2);
plot(t, p);
xlabel('Time');
ylabel('Amplitude');
title('Carrier Signal');

-- % Plot the natural sampling signal
subplot(3,1,3);
plot(t, s);
xlabel('Time');
ylabel('Amplitude');
title('Natural Sampling');

-- % Define y variable (there's a typo in the original code)
y = unicode(5,3,1);

-- % Plot the flat-top sampled signal
subplot(4,1,4);
plot(t, y);
xlabel('Time');
ylabel('Amplitude');
title('Flat Top Scaling');
