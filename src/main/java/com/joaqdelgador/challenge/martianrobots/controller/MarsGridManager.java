package com.joaqdelgador.challenge.martianrobots.controller;

import com.joaqdelgador.challenge.martianrobots.MarsGrid;

public interface MarsGridManager {
 MarsGrid createMarsGrid(int x, int y) throws Exception;
}
