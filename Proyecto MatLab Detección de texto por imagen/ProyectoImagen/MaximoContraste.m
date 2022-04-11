function immaxcont = MaximoContraste(im)
M = max(max(im));
m = min(min(im));

if(isinteger(max(max(im))))
    I = ((im - m)./(M - m))* 255;
else
    I = (im - m)./(M - m);
end
immaxcont = I;
end