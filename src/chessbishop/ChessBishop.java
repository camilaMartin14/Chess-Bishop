package chessbishop;


//Falta corregir


import java.util.InputMismatchException;
import java.util.Scanner;

public class ChessBishop {
/*
Create a char array 8x8 similar to the movement of a chess bishop.
Pudiendose mover en diagonal dentro del tablero.
Deberas mostrar donde se encuentra en cada momento.
Su posicion inicial es aleatoria
Podes usar un menu.    
*/
   
    public static void main(String[] args) {
      
        final char VACIO= 'X';
        final char ALFIL = 'O';

        char [][] matriz= new char [8][8];
    
        rellenarMatriz(matriz, VACIO);
        
        int posActualAlfilX = generateRandomNumber(0, matriz.length-1);
        int posActualAlfilY = generateRandomNumber(0, matriz[0].length-1);
        
        int dirX = 0;
        int dirY = 0;
        
        int posAntiguaAlfilX = dirX;
        int posAntiguaAlfilY = dirY;
        
      
        matriz[posActualAlfilX][posActualAlfilY]= ALFIL;

        Scanner sc = new Scanner (System.in);
        boolean salir = false;
        int opcion; //guarda opcion elegida x usuario
    
     
        while (!salir){
            
            mostrarMatriz(matriz);
            
            System.out.println("¿Dónde quires moverte?");
            System.out.println("1. Mover arriba-derecha");
            System.out.println("2. Mover abajo - derecha");
            System.out.println("3. Mover abajo-izquierda");
            System.out.println("4. Mover arriba-izquierda");
            System.out.println("5. Salir");

            try {
                System.out.println("Escribe una de las opciones");
                opcion = sc.nextInt();
            
                posAntiguaAlfilX = posActualAlfilX;
                posAntiguaAlfilY = posActualAlfilY;

                switch (opcion) {
                    case 1:
                        dirX = -1;
                        dirY = 1;
                        break;

                    case 2:
                        dirX = 1;
                        dirY = 1;
                        break;

                    case 3:
                        dirX = 1;
                        dirY = -1;
                        break;

                    case 4:
                        dirX = -1;
                        dirY = -1;
                        break;

                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo numeros entre 1 y 5");
                        
                }
                int nuevaPosAlfilX = posActualAlfilX + dirX;
                int nuevaPosAlfilY = posActualAlfilY + dirY;
                
                while (estaLimiteMatriz (matriz.length, matriz[0].length, 
                                        nuevaPosAlfilX, nuevaPosAlfilY)){
                    posActualAlfilX += dirX;
                    posActualAlfilY += dirY;
                }

                if (estaLimiteMatriz(matriz.length, matriz[0].length, nuevaPosAlfilX, nuevaPosAlfilY)) {
                    matriz[posActualAlfilX][posActualAlfilY] = VACIO;
                    posActualAlfilX = nuevaPosAlfilX;
                    posActualAlfilY = nuevaPosAlfilY;
                    matriz[posActualAlfilX][posActualAlfilY] = ALFIL;
                } else {
                    System.out.println("Te sales del tablero");
                }
                
                /*if (estaLimiteMatriz(matriz.length, matriz[0].length, 
                                    posActualAlfilX+dirX, posActualAlfilY+dirY)) {
                matriz[posAntiguaAlfilX][posAntiguaAlfilY]= VACIO;
                matriz[posActualAlfilX][posActualAlfilY]= ALFIL;
                
                
                }else{
                    System.out.println("Te sales del tablero");
                    posActualAlfilX = posAntiguaAlfilX;
                    posActualAlfilY = posAntiguaAlfilY;
                }*/
                
            }catch (InputMismatchException e) {
                System.out.println("Debes insertar un numero");
                sc.next();
            }
        }
    }
    public static void mostrarMatriz(char[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    public static void rellenarMatriz(char[][] matriz, char simbolo){
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    matriz[i][j] = 'X';
                }
            }
    } 
    
    public static boolean estaLimiteMatriz(int longitudFilas, int longitudColumnas, int x, int y) {
    
        return x>= 0 && x< longitudFilas && y>=0 && y <longitudColumnas;//Acá 0 es la primera columna del array
    }
    
     public static int generateRandomNumber(int minimo, int maximo) {
        return (int) ((Math.random() * (maximo - minimo + 1)) + (minimo));
    }

}