package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


import java.util.Scanner;

public class MyGdxGame extends ApplicationAdapter {
	/*

	 */
	ShapeRenderer sr;
	public BitmapFont font;
	public SpriteBatch batch;

	Color col;
	float r=10;



	Scanner s =new Scanner((System.in));
	float x;

	float y;

	float xleft = 200;
	int player1 = 0;
	int player2 = 0;

	float xspeed = 2;

	float yspeed = 2;



	Paddle lPad;
	Paddle rPad;
	int w=50;

	//int yright = 200;




	@Override
	public void create () {
		sr =new ShapeRenderer();
		col = new Color(Color.WHITE);
		y= (float) Gdx.graphics.getHeight() /2;
		x= (float) Gdx.graphics.getWidth() /2;




		lPad=new Paddle((int) xleft,10,w,10,Color.WHITE);
		//rPad=new Paddle(Gdx.graphics.getWidth()-(10+w),yright,w,50,'v',Color.WHITE);

		font = new BitmapFont();
		batch = new SpriteBatch();

	}

	@Override
	public void render () {
		/*
		if (Gdx.input.isKeyPressed(Input.Keys.UP)){
			if (rPad.getY()+rPad.getH()<Gdx.graphics.getHeight()){
				yright = rPad.getY();
				yright+=5;
				rPad.setY(yright);
				rPad.setY(rPad.getY()+5);
			}

		}

		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
			if (rPad.getY()+rPad.getH()>rPad.getH()){
				yright = rPad.getY();
				yright+=-5;
				rPad.setY(yright);
				rPad.setY(rPad.getY()-5);
			}

		}
 		*/


		/*if (Gdx.input.isKeyPressed(Input.Keys.S)){
			if (lPad.getY()+lPad.getH()>lPad.getH()){
				yleft = lPad.getY();
				yleft += -5;
				lPad.setY(yleft);
				lPad.setY(lPad.getY()-5);
			}

		}*/


		x += xspeed;
		y += yspeed;
		int width = Gdx.graphics.getWidth() -25;
		int height = Gdx.graphics.getHeight() -25;

		if (y > height) {
			yspeed = -2;
		}

		if (y < 15) {
			y = 540;
			x = 960;
		}

		if (x > Gdx.graphics.getWidth() -25) {
			xspeed = xspeed * -1;
		}

		if (x < 20) {
			xspeed = xspeed * -1;
		}




		ScreenUtils.clear(0, 0, 0, 1);


		sr.begin(ShapeRenderer.ShapeType.Filled);
		sr.setColor(Color.WHITE);
		sr.circle(x, y, 15);
		lPad.draw(sr);
		sr.end();

		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			movePaddle(-1);
		}

		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			movePaddle(1);
		}


		//rPad.draw(sr);

		/*if (x > Gdx.graphics.getWidth() + 30) {
			x = (float) Gdx.graphics.getWidth() /2;
			y = (float) Gdx.graphics.getHeight() /2;
			player2 = player2 + 1;
			System.out.println(player1 + " is player 1's score");
			System.out.println(player2 + " is player 2's score");
			if (xspeed < 10 && yspeed < 10){
				xspeed = (float) (xspeed * 1.25);
				yspeed = (float) (yspeed * 1.25);
			}
		}
		if (x < 0) {
			x = (float) Gdx.graphics.getWidth() /2;
			y = (float) Gdx.graphics.getHeight() /2;
			player1 = player1 + 1;
			System.out.println(player1 + " is player 1's score");
			System.out.println(player2 + " is player 2's score");
			if (xspeed < 10 && yspeed < 10){
				xspeed = (float) (xspeed * 1.25);
				yspeed = (float) (yspeed * 1.25);
			}
		}

		batch.begin();
		font.draw(batch, ""+player2, 100, 400);
		font.draw(batch, ""+player1, 500, 400);
		batch.end();*/



	}

	public void movePaddle(int d) {
		if (d == -1){
			if (lPad.getX() > 0){
				lPad.setX(lPad.getX() -5);
				System.out.println(lPad.getX());
			}
		} else if (lPad.getX() + lPad.getW() < Gdx.graphics.getWidth()) {
			lPad.setX(lPad.getX() + 5);
			System.out.println(lPad.getX());
		}

	}




	@Override
	public void dispose () {

	}
}