package com.mataskaairaitis.placeholder;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuScreen implements Screen {

	MyGdxGame game;
	MenuControl control;
	
	SpriteBatch batch;
	BitmapFont unselectedFont;
	BitmapFont highlightedFont;
	Item[] menuItems;
	
	int highlightedItem = 0;
	
	public MenuScreen(MyGdxGame game) {
		this.game = game;
		control = new MenuControl(this);
		
		batch = new SpriteBatch();
		unselectedFont = new BitmapFont();
		highlightedFont = new BitmapFont();
		highlightedFont.setColor(Color.ORANGE);
		
		menuItems = new Item[3];
		menuItems[0] = new Item("New Game", 400, 400);
		menuItems[1] = new Item("Options", 400, 300);
		menuItems[2] = new Item("Exit Game", 400, 200);
	}
	
	class Item {
		String str; int X; int Y;
		public Item(String str, int X, int Y) {
			this.str = str; this.X = X; this.Y = Y;
		}
	}
	
	@Override
	public void show() {
		Gdx.graphics.setContinuousRendering(false);
		game.userInput.setReceiver(control);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1); // Sets background to black
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clears the screen
		batch.begin();
		for(Item item : menuItems) {
			unselectedFont.draw(batch, item.str, item.X, item.Y);
		}
		Item highlight = menuItems[highlightedItem];
		highlightedFont.draw(batch, highlight.str, highlight.X, highlight.Y);
		batch.end();
	}
	
	@Override
	public void resize(int width, int height) {}

	@Override
	public void pause() {}

	@Override
	public void resume() {}

	@Override
	public void hide() {}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	
	
}
