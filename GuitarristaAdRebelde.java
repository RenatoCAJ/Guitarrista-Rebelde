//import processing.serial.*;
//import cc.arduino.*;
//Arduino arduino;

//float x = 50; // posição horizontal inicial do quadrado
float y1 = random(-400, -100); // posição vertical inicial do quadrado
float y2 = random(-400, -100); // posição vertical inicial do quadrado
float y3 = random (-400, -100); // oisicao vertical do quadrado
float y4 = random (-400, -100); // posicao vertical do quadrado
float speed1 = random (2, 3); // velocidade de queda do quadrado
float speed2 = random (2, 3); //
int palhetaselecionada = 0;
int pontuacao = 0;

boolean rect1vermelho = true; // O quadrado quando vdd é visivel
boolean rect2marrom = true; // Caso o valor seja falso, desaparece
boolean rect3amarelo = true; // No caso é verdadeiro
boolean rect4azul = true; // Então visivel

float tempoStar = 60; // tempo da estrela em tela ao clicar
boolean showStar = false; // exibição da estrela
float starX; // Coordena estrela
float starY;
float rotationAngle;  // rotacao da estrela

int valor = 0;
float tempoPalheta = 20;

void setup() {
  size(480, 720);
//  println(Arduino.list());
  //arduino = new Arduino(this, Arduino.list()[0], 57600);
 // arduino.pinMode(2, Arduino.INPUT);
}


//void keyPressed() {

//  if (key=='a') {
//    palhetaselecionada++;
//    if (palhetaselecionada==3) {
//      palhetaselecionada= 0;
//    }
//  }
//

void draw() {
  background(255);
 // valor = arduino.digitalRead(2);
  background(255); // limpa a tela a cada frame
  println("palhetaselecionada: "+palhetaselecionada); //print
  println("pontuacao: "+pontuacao);
  println("y2: "+ y2);

  // Quadrados (inimigos)
  fill(255, 0, 0);
  rect(50, y1, 50, 50); // desenha o quadrado na posição atual
  //quadrado 2 informado que é visivel
  if (rect2marrom) {
    fill(100, 0, 0);
    rect(150, y2, 50, 50); // segundo quadrado
  }
  if (rect3amarelo) {
    fill(250, 250, 0);
    rect(250, y3, 50, 50); // terceiro
  }
  if (rect4azul) {
    fill(100, 200, 250);
    rect(350, y4, 50, 50); // quarto
  }

  // Triangulos (palhetas)
  if (palhetaselecionada == 0) {
    fill(100, 200, 250);
    triangle (20, 670, 10, 650, 50, 630);// Azul

    fill(250, 250, 0);
    triangle(30, 690, 10, 670, 40, 650); //Amarelo

    fill(100, 0, 0);
    triangle (40, 700, 20, 680, 50, 650); // Marron
  } else if (palhetaselecionada == 1) {
    fill(100, 200, 250);
    triangle (20, 670, 10, 650, 50, 630);

    fill(100, 0, 0);
    triangle (40, 700, 20, 680, 50, 650); // 2 Marron

    fill(250, 250, 0);
    triangle(30, 690, 10, 670, 40, 650); // 1 Amarelo
  } else if (palhetaselecionada == 2) {

    fill(100, 0, 0);
    triangle (40, 700, 20, 680, 50, 650); // 3 Marron

    fill(250, 250, 0);
    triangle(30, 690, 10, 670, 40, 650); // 2 Amarelo

    fill(100, 200, 250);
    triangle (20, 670, 10, 650, 50, 630); // 1 Azul
  }



  // Velocidade
  y1 = y1 + speed1; // atualiza a posição vertical do quadrado
  y2 = y2 + speed2; // atualiza a posição vertical do quadrado
  y3 = y3 + speed1;
  y4 = y4 + speed2;

  // Apos chegar no fim da tela vertical, continua o cilco correspondente
  if (y1 > 720) {
    y1 = random(-400, -50); //ciclo de renascimento do rect
  }
  if (y2 > 720) {
    y2 = random(-400, -50);
  }
  if (y3 > 720) {
    y3 = random(-400, -50);
  }
  if (y4 > 720) {
    y4 = random(-400, -50);
  }

  //Estrela
  if (showStar) {
    fill(0, 0, 0);
    pushMatrix();
    //translate(width*0.8, height*0.5);
    rotate (radians(rotationAngle)); // Aplica rotacao a estrela
    rotationAngle++; // Incrementa a rotacao
    star(starX, starY, 10, 20, 5);
    popMatrix();
    if (frameCount % tempoStar == 0) { // verifica a animacao
      showStar = false; // para de exibir
    }
  }
  //ellipse(320, 240, valor*100, valor*100);
  //if ( valor == 1 ) {
    //valor = 1;
    //palhetaselecionada++;
    //if (palhetaselecionada == 3) { 
    //  palhetaselecionada = 0;
     if (palhetaselecionada == 0 && valor == 1) {
    if (frameCount % tempoPalheta == 0) {
       palhetaselecionada = 1;
    }
    //tempoPalheta = 60;
    }
     else if (palhetaselecionada == 1 && valor == 1) {
    if (frameCount % tempoPalheta == 0){
       palhetaselecionada = 2;
    }
    //tempoPalheta = 60;
    } 
   else if (palhetaselecionada == 2 && valor == 1) {
     if (frameCount % tempoPalheta == 0) { 
     palhetaselecionada = 0;
     }
      //tempoPalheta = 60;
    }
    
  
 // pontuacao++;
  //println(pontuacao);
  //rect2marrom = false;
  //y2 = random (-400. -50);
  //rect2marrom = true;
  //}
  println (valor);
}
void mouseClicked(){
 starX = mouseX; // posicao do mouse com a da estela
 starY = mouseY; //
 rotationAngle = 0;
 showStar = true; //  Ativa a exibicao da estrela
  //pushMatrix();
  //translate(width*0.8, height*0.5);
  //rotate(frameCount / -50.0);
  //star(mouseX, mouseY, 10, 20, 5); 
  //popMatrix();
}
void keyPressed() {

  if (key=='a') {
    palhetaselecionada++;
    if (palhetaselecionada==3) {
      palhetaselecionada= 0;
    }
  }
}

void mousePressed() {
  if (palhetaselecionada == 0 && mouseX > 150 && mouseX < 200 && mouseY > y2 && mouseY< y2+50) {
   pontuacao++;
    println(pontuacao);
    rect2marrom = false; // O quadrado some apos clicar nele
    y2 = random (-400, -50); // O quadado reaparece aleatoriamente
    rect2marrom = true; // Torna o quadrado visivel
    
  } else if (palhetaselecionada == 1 && mouseX > 250 && mouseX < 300 && mouseY > y3 && mouseY < y3+50) {
    pontuacao++;
    //println(pontuacao);
    rect3amarelo = false;
    y3 = random (-400, -50);
    rect3amarelo = true;
  } else if (palhetaselecionada == 2 && mouseX > 350 && mouseX < 400 && mouseY > y4 && mouseY < y4+50) {
    pontuacao++;

    rect4azul = false;
    y4 = random (-400, -50);
    rect4azul = true;
  }
}

void star(float x, float y, float radius1, float radius2, int npoints) {
 float angle = TWO_PI / npoints;
  float halfAngle = angle/2.0;
  beginShape();
  for (float a = 0; a < TWO_PI; a += angle) {
    float sx = x + cos(a) * radius2;
    float sy = y + sin(a) * radius2;
    vertex(sx, sy);
    sx = x + cos(a+halfAngle) * radius1;
    sy = y + sin(a+halfAngle) * radius1;
    vertex(sx, sy);
  }
  endShape(CLOSE);
}
