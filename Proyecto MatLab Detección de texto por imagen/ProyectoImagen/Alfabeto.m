function Alfabeto

im = imread('alfabeto.bmp');
punto_inicio_fila = 1;
contador = 1;
R1 = im(:,:,1);
G1 = im(:,:,2);
B1 = im(:,:,3);
imbn = 0.3*R1+0.59*G1+0.11*B1;
%figure;imshow(imbn);title('Imagen en escala de grises');
imcontraste=MaximoContraste(imbn); %Binarizacion
%figure;imshow(imcontraste);title('Imagen binarizada');
imneg=255-imcontraste;
%figure;imshow(imneg);title('Imagen invertida');
sumafilas = sum(imneg,2);
sumafilasnormalizada = (sumafilas/(410e3));
%plot(sumafilasnormalizada);ylim([0 1.5]);

for i=1:length(sumafilasnormalizada)
    if sumafilasnormalizada(i,:)>0.03
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
%     figure();imshow(imfila);
    sumacolumnas = sum(imfila);
    sumacolumnasnormalizada = (sumacolumnas/(7*10e2));
    
     %figure();plot(sumacolumnasnormalizada);xlim([0 450]);
    k=1;
    while (k<length(sumacolumnasnormalizada))
        
        
        while (sumacolumnasnormalizada(:,k) <0.1)
            
            if(k==length(sumacolumnasnormalizada))
                break
            else
                k=k+1;              
            end
        end
        
        if(k==length(sumacolumnasnormalizada))
            break
        else
            punto_inicio_letra = k;
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
        [m1,n1]=size(carcuadrada);
        carcuadrada2 = [zeros(1,n1);carcuadrada;zeros(1,n1)];
       [m2,n2]=size(carcuadrada2);
       carcuadrada3 = [zeros(m2,1) carcuadrada2 zeros(m2,1)];
        carNN = imresize(carcuadrada3,[32 32]);
       %  figure();imshow(carNN);
         
         switch contador
            case 1
                imwrite(carNN,'A.png');
            case 2
                imwrite(carNN,'B.png');
            case 3
                imwrite(carNN,'C.png');
            case 4
                imwrite(carNN,'D.png');
            case 5
                imwrite(carNN,'E.png');
            case 6
                imwrite(carNN,'F.png');
            case 7
                imwrite(carNN,'G.png');
            case 8
                imwrite(carNN,'H.png');
            case 9
                imwrite(carNN,'I.png');
            case 10
                imwrite(carNN,'J.png');
            case 11
                imwrite(carNN,'K.png');
            case 12
                imwrite(carNN,'L.png');
            case 13
               imwrite(carNN,'M.png');
            case 14
                imwrite(carNN,'N.png');
            case 15
                imwrite(carNN,'O.png');
            case 16
                imwrite(carNN,'P.png');
            case 17
                imwrite(carNN,'Q.png');
            case 18
                imwrite(carNN,'R.png');
            case 19
                imwrite(carNN,'S.png');
            case 20
                imwrite(carNN,'T.png');
            case 21
                imwrite(carNN,'U.png');
            case 22
                imwrite(carNN,'V.png');
            case 23
                imwrite(carNN,'W.png');
            case 24
                imwrite(carNN,'X.png');
            case 25
                imwrite(carNN,'Y.png');
            case 26
                imwrite(carNN,'Z.png');
         end
        contador = contador+1;
    end
end