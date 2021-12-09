import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.*;


public class ElementosVisuales{
	//Atributos para pantalla de presentación
    JFrame ventana;
    JPanel panelPresentacion;
    JLabel fondoPresentacion;
    JLabel botonJugar;
	
	//Atributos para el juego
    JPanel panelJuego;
    JLabel fondoJuego;
    JLabel matriz[][];
    int mat [][];
    int matAux [][];
    Random aleatorio;
	Timer tiempo;
    JLabel cronometro;
    int min, seg, contador, contSegEsp, ban, ban1;
    Timer tiempoEspera, tiempoEspera1;
    
	
    //para eliminar cartas iguales
    int antnum;
    int antx, anty;
    int actualnum;
    int actualx, actualy;
	
	
	
	public void ElementosVisuales(){
	/******************************************************/
    /*VENTANA DE IINICIO*/
	
		//Crea la ventana de inicio
		ventana = new JFrame("Projecto final POO");
		
		//Asigna un tamaño a la ventana de inicio
		ventana.setSize(966,510);
		
		//Deshabilita el boton de maximizar ventana
		ventana.setResizable(false);
		
		//Permite colocar los demas componentes en la ventana
		ventana.setLayout(null);
		
		//Finaliza el programa al cerrar la ventana
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Inicia la ventana en el centro de la pantalla
		ventana.setLocationRelativeTo(null);
		
		
	
	
	/******************************************************/
    /*PANEL DE PRESENTACIÓN*/
	
		//Inicializa la variable
		panelPresentacion = new JPanel();
		
		//Establece las medidas 
		panelPresentacion.setSize(ventana.getWidth(), ventana.getHeight());
		
		//Coordenadas de inicio para el panel de presentación
		panelPresentacion.setLocation(0,0);
		
		//Permite colocar los demas componenetes en la ventana
		panelPresentacion.setLayout(null);
		
		//hace visible la ventana panelPresentacion
		panelPresentacion.setVisible(true);
	
	
	/******************************************************/
    /*FONDO DE PRESENTACIÓN*/
	
		//Inicializa la variable
		fondoPresentacion = new JLabel();
		
		//Asigna tamño al fondo de presentación
		fondoPresentacion.setSize(ventana.getWidth(),ventana.getHeight());
		
		//Coordenadas para el fondo
		fondoPresentacion.setLocation(0,-20);
		
		//Agrega una imagen de fondo
		fondoPresentacion.setIcon(new ImageIcon("imagenes/fondoDeInicio960x469.jpg"));
		
		//Hace visible la imagen de fondo
		fondoPresentacion.setVisible(true);
		
		//Agregar al panel de presentación
		panelPresentacion.add(fondoPresentacion,0);
		
		//agregar panelPresentacion a la ventana
		ventana.add(panelPresentacion,0);	
	
	
	/******************************************************/
    /*BOTON JUGAR*/

		botonJugar = new JLabel();
		
		//Tamaño del boton
		botonJugar.setSize(124,50);
		
		//Coordenadas
		botonJugar.setLocation(10,10);
		
		//Imagen del boton jugar
		botonJugar.setIcon(new ImageIcon("imagenes/botonJugar125x44.png"));
		
		//Hace visible el boton jugar
		botonJugar.setVisible(true);
		
		//agrega el boton jugar al panel
		panelPresentacion.add(botonJugar,0);
		
		
	/******************************************************/
    /*propiedades de la variable JPanel panelJuego */
       	
		panelJuego = new JPanel();
		
		//Tamaño de la ventana
		panelJuego.setSize(ventana.getWidth(), ventana.getHeight());
		
		//Coordenadas
		panelJuego.setLocation(0,0);
		
		//permite colocar los demas componenetes en la ventana
		panelJuego.setLayout(null);
		
		//Hace visible panelJuego
		panelJuego.setVisible(true);
		
		
	/******************************************************/
	/*FONDO DE JUEGO*/		
		
		fondoJuego = new JLabel();
		
		//Asigna tamaño al fondo
		fondoJuego.setSize(ventana.getWidth(),ventana.getHeight());
		
		//Coordenadas
		fondoJuego.setLocation(0,0);
		
		//Agrega imagen de fondo
		//fondoJuego.setIcon(new ImageIcon("imagenes/fondoDeJuego.jpeg"));
		//fondoJuego.setForeground(Color.BLUE);
		
		//Hace visible el fondo del juego
		fondoJuego.setVisible(true);
		
		//Agrega al panel
		panelJuego.add(fondoJuego);
	
	
	/******************************************************/
    /*CRONÓMETRO*/
		
		//Inicia variable cronometro
		cronometro = new JLabel();
		
		//Tamaño de cronometro
		cronometro.setSize(150,20);
		
		//Coordenadas
		cronometro.setLocation(ventana.getWidth()-200,10);
		
		//Color
		cronometro.setForeground(Color.BLACK);
		
		//Hace visible el cronometro
		cronometro.setVisible(true);
		
		//Agrega al panel 
		panelJuego.add(cronometro,0);
		
		
	/******************************************************/ 
	/*MATRIZ LÓGICA*/
	
		//inicializar matriz de enteros mat y matAux
		mat = new int[4][5];
		
		matAux = new int[4][5];
		
		aleatorio = new Random();
		
		this.numerosAleatorios();
		
		
	/******************************************************/
	/*MATRIZ DE IMAGENES*/	
		
		matriz = new JLabel[4][5];
		
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                matriz[i][j] = new JLabel();
				
				//Coordenadas para cada una de las cartas
				matriz[i][j].setBounds(125+(j*125), 20+(i*152), 125,152);
				
				//Establece las imagenes/botonJugar125x44
				matriz[i][j].setIcon(new ImageIcon("imagenes/"+matAux[i][j]+".jpg"));
				
				//Hace visible cada carta de la matriz de imagenes
				matriz[i][j].setVisible(true);
				
				//Agrega la matriz de imagenes al panel de juego
				panelJuego.add(matriz[i][j],0);
			}
		}
		
	
	/******************************************************/
	/*TEMPORIZADOR*/
		
		//Inicializar minutos y segundos
		min = 0;
		seg = 0;
	
		//Time management
		tiempo = new Timer(1000,new ActionListener(){
			public void actionPerformed(ActionEvent e){
               seg++;
               if(seg == 60){
                   min++;
                   seg = 0;
				}
               cronometro.setText("Tiempo: " + min + ":" + seg);
			}
       });
       
	
	/******************************************************/
	/*TIEMPO DE ESPERA AL VOLTEAR LAS CARTAS*/		
		contSegEsp = 0;
		tiempoEspera = new Timer(1000,new ActionListener(){
			public void actionPerformed(ActionEvent e){
               contSegEsp ++;
			}
		});
		tiempoEspera.start();
		tiempoEspera.stop();
		contSegEsp = 0;
		ban = 0;
		ban1 = 0;
		
		
	/******************************************************/
	/*EVENTO DE CLICK DE LAS CARTAS*/	
		
		contador = 0;
		
		for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                matriz[i][j].addMouseListener(new MouseAdapter(){
                    @Override
                    public void mousePressed(MouseEvent e){
                        for (int k = 0; k < 4; k++) {
                            for (int l = 0; l < 5; l++) {
                                if(e.getSource() == matriz[k][l]){
									
									//voltear las cartas si son iguales
									if(matAux[k][l] == 0 && contador != 2){
                                        matAux[k][l] = mat[k][l];
                                        matriz[k][l].setIcon(new ImageIcon("imagenes/" + matAux[k][l] + ".jpg"));
                                        
                                        contador ++;
										
										//Identifica y elimina cartas iguales
										actualnum = mat[k][l];
                                        actualx = k;
                                        actualy = l;
                                        if(contador == 1){ 
                                            antnum = mat[k][l];
                                            antx = k;
                                            anty = l;
                                        }
										
										//Pausa al voltear 2 cartas
										tiempoEspera1 = new Timer(500,new ActionListener(){
                                            public void actionPerformed(ActionEvent e){
                                                
                                                if(contador == 2 && ban1 == 0){
                                                    tiempoEspera.restart();
                                                    ban1 = 1;
                                                }
                                                if(contador == 2 && contSegEsp == 2){
                                                    tiempoEspera.stop();
                                                    contSegEsp = 0;
													
													//Si las cartas son iguales las desaparece
													if(matAux[actualx][actualy] == matAux[antx][anty]){
                                                        matAux[actualx][actualy] = -1;
                                                        matAux[antx][anty] = -1;
                                                        matriz[actualx][actualy].setIcon(new ImageIcon("imagenes/" + matAux[actualx][actualy] + ".jpg"));
                                                        matriz[antx][anty].setIcon(new ImageIcon("imagenes/" + matAux[antx][anty] + ".jpg"));
                                                        contador = 0;
														
														/*/Una vez que todas las cartas desaparecen 
														Finalizar juego*/
														
														/*Cuenta cada vez que una carta desaparece*/
														int acum = 0;
                                                        for (int m = 0; m < 4; m++) {
                                                            for (int n = 0; n < 5; n++) {
                                                                if(matAux[m][n] == -1)
                                                                    acum++;
                                                            }
                                                        }
														
														//Cuando todas las cartas desaparecen
														if(acum == 20){
                                                            tiempo.stop();
															JOptionPane.showMessageDialog(ventana,"FELICIDADES HAS GANADO!\nTIEMPO: "+min+ ":" +seg);
														
														
															//REINICIA EL JUEGO UNA VEZ GANADO
															for (int m = 0; m < 4; m++) {
                                                                for (int n = 0; n < 5; n++) {
                                                                    mat[m][n] = 0;
                                                                    matAux[m][n] = 0;
																	
																	//Todas las cartas se muestran bocabajo
																	matriz[m][n].setIcon(new ImageIcon("imagenes/" + matAux[m][n] + ".jpg"));
																}
															}
															//Barajea las cartas y les asigna valor aleatorio en la matriz
															numerosAleatorios();
															
															//REINICIA EL TIEMPO PARA EL SIGUIENTE JUEGO
                                                            min = 0;
                                                            seg = 0;
                                                            tiempo.restart();
                                                        }
                                                    }
													
													//Pone las cartas bocabajo
                                                    for (int m = 0; m < 4; m++) {
                                                        for (int n = 0; n < 5; n++) {
                                                            if(matAux[m][n] != 0 && matAux[m][n] != -1){
                                                                matAux[m][n] = 0;
                                                                matriz[m][n].setIcon(new ImageIcon("imagenes/" + matAux[m][n] + ".jpg"));
                                                                contador = 0;
                                                            }
                                                        }
                                                    }
                                                    tiempoEspera1.stop();
                                                    ban1 = 0;
                                                }
                                                
                                            }
                                        });
										
										//Tiempo de espera para voltear dos cartas
										if(ban == 0){
                                            tiempoEspera1.start();
                                            ban = 1;
                                        }
                                        if(contador == 2 )
                                            tiempoEspera1.restart();
                                        
                                        
                                        
                                    }
                                }
                            }
                            
                        }
                    }
                });
            }
        }
       
       
	/******************************************************/
	/*EVENTO DE MOUSE PARA EL BOTON DE JUGAR*/	
		
		//Al dar click en el botón jugar
		
		botonJugar.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				
				//hace visible el cronómetro al dar click en jugar
				tiempo.start();
				
				//Desaparece el panel de presentación
				panelPresentacion.setVisible(false);
			
				//Añade el panel de juego a la ventana
				ventana.add(panelJuego);
				
				//se hace visible el panel de juego
				panelJuego.setVisible(true);
				
				//Cambia el tamaño a la ventana de inicio
				ventana.setSize(900,700);
				
				//Inicia la ventana en el centro de la pantalla
				ventana.setLocationRelativeTo(null);
				
				//Cambia el tamaño del panel de juego
				panelJuego.setSize(ventana.getWidth(), ventana.getHeight());
				
			}
		});
		
		//Agrega panelPresentacion a la ventana
		ventana.add(panelPresentacion,0);
		
		//Hace visible la ventana
		ventana.setVisible(true);
	}




	
	public void numerosAleatorios(){
		int acumulador = 0;
		
		//Inicializa las matrices en 0
		for(int i = 0; i < 4; i++) 
            for (int j = 0; j < 5; j++){
                mat[i][j] = 0;
                matAux[i][j] = 0;
            }
		
		for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
				//Le asigna un valor aleatorio a cada 
				//elemento de la matriz lógica principal
				mat[i][j] = aleatorio.nextInt(10)+1;
				
				/*ciclo mediante el cual se asegura que la 
				matriz lógica se inicialice con valores del 
				1 al 10 y que solo se repitan dos valores de
				cada uno en toda la matriz*/
				do{
                    acumulador = 0;
                    for (int k = 0; k < 4; k++) {
                        for (int l = 0; l < 5; l++) {
							//Si hay un valor repetido en la matriz
							//acumulador aumenta su valor en 1
							if (mat[i][j] == mat[k][l]) {
                                acumulador += 1;
                            }
                        }
                    }
					
					//Si hay tres valores iguales dentro de la matriz
					//se le asiga un valor diferente al elemento de la matriz
					if (acumulador == 3) {
                        mat[i][j] = aleatorio.nextInt(10)+1;
                    }
                }while(acumulador == 3);
            }
        }
	}

















}