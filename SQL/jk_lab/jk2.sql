clc;           % Clears the command window
close all;     % Closes all open figure windows
clear all;     % Clears all variables from the workspace

-- % Prompt user for input values
n = input('Enter n value for n-bit PCM system');
n1 = input('Enter number of samples in a period');
L = 2^n;

-- % Generate analog signal
x = 0 : 2*pi/n1 : 4*pi;
s = 8*sin(x);

-- % Plot the analog signal
subplot(3,1,1);
plot(s);
title('ANALOG SIGNAL');
ylabel('AMPLITUDE ---------------->');
xlabel('TIME ----------------->');

-- % Sample the analog signal
subplot(3,1,2);
stem(s);
grid on;
title('SAMPLED SIGNAL');
ylabel('AMPLITUDE ---------------->');
xlabel('TIME ----------------->');

-- % Quantization
vmax = 8;
vmin = -vmax;
del = (vmax - vmin) / L;
part = vmin : del : vmax;
code = vmin - (del/2) : del : vmax + (del/2);

[ind, q] = quantize(s, part, code);

-- % Adjust indices and quantized values
l1 = length(ind);
l2 = length(q);

for i = 1 : l1
    if(ind(i) ~= 0)
        ind(i) = ind(i) - 1;
    end
    i = i + 1;
end

for i = 1 : l2
    if(q(i) == vmin - (del/2))
        q(i) = vmin + (del/2);
    end
end

-- % Plot the quantized signal
subplot(3,1,3);
stem(q);
grid on;
title('QUANTIZED SIGNAL');
ylabel('AMPLITUDE ---------------->');
xlabel('TIME ----------------->');

figure;

-- % Encoding
code = de2bi(ind, 'left-msb');
k = 1;

for i = 1 : l1
    for j = 1 : n
        code(k) = code(i, j);
        j = j + 1;
        k = k + 1;
    end
    i = i + 1;
end

-- % Plot the encoded signal
subplot(2,1,1);
grid on;
stairs(code);
axis([0 100 -2 3]);
title('ENCODED SIGNAL');
ylabel('AMPLITUDE ---------------->');
xlabel('TIME ----------------->');

-- % Demodulation
qunt = reshape(code, n, length(code)/n);
index = bi2de(qunt, 'left-msb');
q = del * index + vmin + (del/2);

-- % Plot the demodulated signal
subplot(2,1,2);
grid on;
plot(q);
title('DEMODULATED SIGNAL');
ylabel('AMPLITUDE ---------------->');
xlabel('TIME ----------------->');
