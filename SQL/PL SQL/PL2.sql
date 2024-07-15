-- Using a Loop to Print Numbers 1 to 10:
 
DECLARE
    i NUMBER := 1;
BEGIN
    LOOP
        IF i > 10 THEN
            EXIT;
        END IF;
        DBMS_OUTPUT.PUT_LINE(i);
        i := i + 1;
    END LOOP;
END;


-- Using a FOR Loop to Print Numbers 1 to 10:
DECLARE
    i NUMBER;
BEGIN
    FOR i IN 1..10 LOOP
        DBMS_OUTPUT.PUT_LINE(i);
    END LOOP;
END;

 
-- Using a FOR REVERSE Loop to Print Numbers in Reverse Order:
DECLARE
    i NUMBER;
BEGIN
    FOR i IN REVERSE 1..10 LOOP
        DBMS_OUTPUT.PUT_LINE(i);
    END LOOP;
END;


-- Determining if a Number is Even or Odd:
DECLARE
    n NUMBER := :n;
BEGIN
    IF MOD(n, 2) = 0 THEN
        DBMS_OUTPUT.PUT_LINE('The number is even');
    ELSE
        DBMS_OUTPUT.PUT_LINE('The number is odd');
    END IF;
END;

-- Finding the Greatest of Three Numbers (a, b, c):
DECLARE
    a NUMBER := :a;
    b NUMBER := :b;
    c NUMBER := :c;
BEGIN
    DBMS_OUTPUT.PUT_LINE('a=' || a || ' b=' || b || ' c=' || c);
    IF a > b AND a > c THEN
        DBMS_OUTPUT.PUT_LINE('a is the greatest');
    ELSIF b > a AND b > c THEN
        DBMS_OUTPUT.PUT_LINE('b is the greatest');
    ELSE
        DBMS_OUTPUT.PUT_LINE('c is the greatest');
    END IF;
END;

-- Calculating Factorial Using a While Loop:
DECLARE
    num NUMBER := :num;
    fact NUMBER := 1;
    temp NUMBER := num;
BEGIN
    WHILE temp > 0 LOOP
        fact := fact * temp;
        temp := temp - 1;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('Factorial of ' || num || ' is ' || fact);
END;

-- Printing a Pyramid Pattern Using Nested Loops:
DECLARE
    n NUMBER := 5;
    i NUMBER;
    j NUMBER;
BEGIN
    FOR i IN 1..n LOOP
        FOR j IN 1..i LOOP
            DBMS_OUTPUT.PUT('*');
        END LOOP;
        DBMS_OUTPUT.NEW_LINE;
    END LOOP;
END;
 