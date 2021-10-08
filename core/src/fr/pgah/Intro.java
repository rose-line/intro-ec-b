package fr.pgah;

import java.nio.charset.CoderResult;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Intro extends ApplicationAdapter {
  SpriteBatch batch;

  Texture[] imgs;
  int[] coordonneesX;
  int[] coordonneesY;
  int[] hauteursImgs;
  boolean[] montent;
  int hauteurFenetre;

  @Override
  public void create() {
    batch = new SpriteBatch(); /// affectation + instanciation

    imgs = new Texture[2];
    imgs[0] = new Texture("sio.jpg");
    imgs[1] = new Texture("badlogic.jpg");

    coordonneesX = new int[2];
    coordonneesX[0] = 0;
    coordonneesX[1] = 100;

    coordonneesY = new int[2];
    coordonneesY[0] = 0;
    coordonneesY[1] = 200;

    hauteursImgs = new int[2];
    hauteursImgs[0] = imgs[0].getHeight();
    hauteursImgs[1] = imgs[1].getHeight();

    montent = new boolean[2];
    montent[0] = true;
    montent[1] = false;

    hauteurFenetre = Gdx.graphics.getHeight();
  }

  @Override
  public void render() {
    reinitialiserBackground();
    testerBordures();
    majCoordonnees();
    dessiner();
    // dummy
    // dummy 2
  }

  private void dessiner() {
    batch.begin();

    for (int i = 0; i <= 1; i++) {
      batch.draw(imgs[i], coordonneesX[i], coordonneesY[i]);
    }

    batch.end();
  }

  private void majCoordonnees() {

    for (int i = 0; i <= 1; i++) {
      coordonneesX[i] = coordonneesX[i] + 1; // incrémentation

      if (montent[i]) {
        coordonneesY[i] = coordonneesY[i] + 1;
      } else {
        coordonneesY[i] = coordonneesY[i] - 1;
      }
    }
  }

  private void testerBordures() {
    // Test de bordure supérieure
    if (y + hauteurImage == hauteurFenetre) {
      onMonte = false;
    }

    // Test de bordure inférieure
    if (y == 0) {
      onMonte = true;
    }
  }

  public void reinitialiserBackground() {
    ScreenUtils.clear(1, 0, 0, 1);
  }
}
