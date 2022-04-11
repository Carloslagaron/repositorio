function DetectaLetras(imc)

%FUNCION QUE DETECTA LOS CARACTERES DE UNA IMAGEN

Alfabeto;
A=imread('A.png');
B=imread('B.png');
C=imread('C.png');
D=imread('D.png');
E=imread('E.png');
F=imread('F.png');
G=imread('G.png');
H=imread('H.png');
I=imread('I.png');
J=imread('J.png');
K=imread('K.png');
L=imread('L.png');
M=imread('M.png');
N=imread('N.png');
O=imread('O.png');
P=imread('P.png');
Q=imread('Q.png');
R=imread('R.png');
S=imread('S.png');
T=imread('T.png');
U=imread('U.png');
V=imread('V.png');
W=imread('W.png');
X=imread('X.png');
Y=imread('Y.png');
Z=imread('Z.png');

im = imread(imc);
figure;imshow(im);title('Imagen original');
R1 = im(:,:,1);
G1 = im(:,:,2);
B1 = im(:,:,3);
imbn = 0.3*R1+0.59*G1+0.11*B1;
figure;imshow(imbn);title('Imagen en escala de grises');
imcontraste=MaximoContraste(imbn); %Binarizacion
figure;imshow(imcontraste);title('Imagen binarizada');
imneg=255-imcontraste;
figure;imshow(imneg);title('Imagen invertida');
sumafilas = sum(imneg,2);
sumafilasnormalizada = (sumafilas/(410e3));
%plot(sumafilasnormalizada);ylim([0 1.5]);

for i=1:length(sumafilasnormalizada)
    if sumafilasnormalizada(i,:)>0.01
        sumafilasnormalizada(i,:)=1;
    end
end
 %plot(sumafilasnormalizada);ylim([0 1.5]);

j=1;
while (j<length(sumafilasnormalizada))

    while (sumafilasnormalizada(j,:) ==0)

        if(j==length(sumafilasnormalizada))

            break
        else
            j=j+1;
        end
    end

    if(j==length(sumafilasnormalizada))
        break
    else
        punto_inicio_fila = j;
    end

    while (sumafilasnormalizada(j,:) ==1)

        j=j+1;

    end

    punto_final_fila = j;

    j = j+3;

    imfila = imneg(punto_inicio_fila:punto_final_fila,:);
    figure();imshow(imfila);
    
    sumacolumnas = sum(imfila);
    sumacolumnasnormalizada = (sumacolumnas/(7*10e2));

%     figure();plot(sumacolumnasnormalizada);xlim([0 450]);
    k=1;
    while (k<length(sumacolumnasnormalizada))
        espacio_negro=0;

        while (sumacolumnasnormalizada(:,k) <0.1)

            if(k==length(sumacolumnasnormalizada))
                break
            else
                k=k+1;
                espacio_negro = espacio_negro+1;
            end
        end

        if(k==length(sumacolumnasnormalizada))
            break
        else
            punto_inicio_letra = k;
        end

        if(espacio_negro>=7)

             fprintf(" ");
        else

        end

        while (sumacolumnasnormalizada(:,k) >0.1)

            if(k==length(sumacolumnasnormalizada))
                break
            else
                k=k+1;
            end

        end

        punto_final_letra = k;

        k = k+1;

      car = imfila(:,punto_inicio_letra:punto_final_letra);
        [m,n]=size(car);
        carcuadrada = [zeros(m,fix((m-n)/2)) car zeros(m,fix((m-n)/2))];
        [~,n1]=size(carcuadrada);
        carcuadrada2 = [zeros(1,n1);carcuadrada;zeros(1,n1)];
        [m2,~]=size(carcuadrada2);
        carcuadrada3 = [zeros(m2,1) carcuadrada2 zeros(m2,1)];
        carNN = imresize(carcuadrada3,[32 32]);
       %  figure();imshow(carNN);

        matriz_corr=[corr2(carNN,A), corr2(carNN,B), corr2(carNN,C), corr2(carNN,D), corr2(carNN,E), corr2(carNN,F), corr2(carNN,G), corr2(carNN,H), corr2(carNN,I), corr2(carNN,J), corr2(carNN,K), corr2(carNN,L), corr2(carNN,M), corr2(carNN,N), corr2(carNN,O),corr2(carNN,P), corr2(carNN,Q), corr2(carNN,R), corr2(carNN,S), corr2(carNN,T), corr2(carNN,U), corr2(carNN,V), corr2(carNN,W),corr2(carNN,X), corr2(carNN,Y), corr2(carNN,Z)];

        [~,b]=max(matriz_corr);

        letra = b;
        switch letra
            case 1
                fprintf("A");
            case 2
                fprintf("B");
            case 3
                fprintf("C");
            case 4
                fprintf("D");
            case 5
                fprintf("E");
            case 6
                fprintf("F");
            case 7
                fprintf("G");
            case 8
                fprintf("H");
            case 9
                fprintf("I");
            case 10
                fprintf("J");
            case 11
                fprintf("K");
            case 12
                fprintf("L");
            case 13
                fprintf("M");
            case 14
                fprintf("N");
            case 15
                fprintf("O");
            case 16
                fprintf("P");
            case 17
                fprintf("Q");
            case 18
                fprintf("R");
            case 19
                fprintf("S");
            case 20
                fprintf("T");
            case 21
                fprintf("U");
            case 22
                fprintf("V");
            case 23
                fprintf("W");
            case 24
                fprintf("X");
            case 25
                fprintf("Y");
            case 26
                fprintf("Z");           
        end
    end

    fprintf("\n");

end
end

