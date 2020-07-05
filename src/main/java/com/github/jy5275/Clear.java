package com.github.jy5275;

import java.awt.event.*;

class ClearTrace implements ActionListener {
    Mainfile frame;

    public ClearTrace(Mainfile f) {
        frame = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.ClearTrace();
    }
}

class ClearAll implements ActionListener {
    Mainfile frame;

    public ClearAll(Mainfile f) {
        frame = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.ClearAll();
    }
}

class ShowTrace implements ActionListener {
    Mainfile frame;

    public ShowTrace(Mainfile f) {
        frame = f;
    }

    public void actionPerformed(ActionEvent e) {
        if (frame.showT) {	// Disable traces!
            frame.showT = false;
            frame.ClearTrace();
        } else{				// Enable traces!
            frame.showT = true;
            for (Planet p:frame.planets)
                p.AddTrace();
        }
    }
}

class MoveScreen implements ActionListener{
    Mainfile frame;

    public MoveScreen(Mainfile f){
        frame = f;
    }

    public void actionPerformed(ActionEvent e){
        frame.moveS = true;
    }
}

class changeMenuAction implements ActionListener{
	Mainfile frame;
	int level;
	public changeMenuAction(Mainfile f,int a) {
		frame = f;
		level = a;
	}
	public void actionPerformed(ActionEvent e) {
		frame.menuLevel = level;
		frame.selected = false;
		switch(level) {
		case 0:	frame.addMainMenu();	break;
		case 1:	frame.addSecMenu();		break;
		case 2:	frame.addLoadMenu();	break;
		case 3:	frame.addModelMenu();	break;
		}
	}
}

class deletePlanet implements ActionListener{
	Mainfile frame;
	public deletePlanet(Mainfile f) {
		frame = f;
	}
	public void actionPerformed(ActionEvent e) {
		if(frame.selected) {
			frame.planets.remove(frame.selectedPlanet);
			frame.selected = false;
			frame.needRedrawTrace = true;
		}
	}
}
