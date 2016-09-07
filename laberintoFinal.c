#include "simpletools.h"                      // Include simpletools header
#include "abdrive.h"                          // Include abdrive header
#include "ping.h" 

int main() {
	drive_speed(26,26);
	pause(1000);
	drive_speed(0,0);
							//entra a el laberinto
	while(1){
		drive_speed(-26,26);          		//gira a la izquierda      
   		pause(20);
   		drive_speed(0,0);

   		if(ping_cm(8) < 10)	{				//si encuentra un pared 
   			drive_speed(26, -26);			// gira a la derecha (mira al frente)
			pause(1000);
			drive_speed(0,0);

			if(ping_cm(8) < 10)	{			//si encuentra una pared
				drive_speed(26, -26);		//gira a la derecha otra vez (mira a la derecha)
				pause(1000);
				drive_speed(0,0);


				if(ping_cm(8) < 10)	{		//si encuentra pared
					drive_speed(26, -26);	//gira a la derecha (mira hacia atras)
					pause(1000);
					drive_speed(0,0);

				}else{
					drive_speed(64, 64);	//sino encuentra pared avanza
				}

			}else{
				drive_speed(64, 64);		//sino encuentra pared avanza

			}
		}else{
			drive_speed(64, 64);			//sino encuentra pared avanza
		}

   	} 										//vuelve al ciclo while y gira a la izquierda
}
