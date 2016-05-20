package com.mataskaairaitis.mazescape.screens;

import com.badlogic.gdx.Screen;
import com.mataskaairaitis.mazescape.Mazescape;
import com.mataskaairaitis.mazescape.input.*;

/**
 * Abstract Screen class, which will combine common elements in
 * Screen subclasses, to avoid code duplication.
 * "ParentScreen" name can be changed - not the best name.
 * @author jarl
 */
public abstract class ParentScreen implements Screen {
	
	Mazescape game;
	InputReceiver control;
	float width, height;
	
	/**
	 * Parent screen constructor, takes the main Game object
	 * as parameter and the class of the InputReceiver.
	 * @param game
	 * @param controlClass
	 */
	public ParentScreen(Mazescape game, Class<?> controlClass) {
		this.game = game;
		try {
			control = (InputReceiver)controlClass.getConstructor(getClass())
					.newInstance(getClass().cast(this));
		} catch (Exception e) {System.out.println(e);};
		width = 1280;
		height = 720;
	}
	
	public Mazescape getGame() { return game; }
	public InputReceiver getControl() { return control; }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void show() {
		game.getUserInput().setReceiver(control);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void hide() {}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void pause() {}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void resume() {}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void resize(int width, int height) {}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {}
	
}
