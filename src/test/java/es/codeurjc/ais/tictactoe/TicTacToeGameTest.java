package es.codeurjc.ais.tictactoe;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import es.codeurjc.ais.tictactoe.TicTacToeGame.EventType;

class TicTacToeGameTest {
	@DisplayName("Test de conexiones")
	@Test
	void testConexion() {
		
		//Comprobamos las conexiones
		
		TicTacToeGame tictactoegame = new TicTacToeGame();
		
		Connection conexion1 = mock(Connection.class);
		Connection conexion2 = mock(Connection.class);
		
		tictactoegame.addConnection(conexion1);
		tictactoegame.addConnection(conexion2);
		
		Player jugador1 = new Player(1, "x", "jugador1");
		Player jugador2 = new Player(2, "o", "jugador2");
		
		List<Player> players = new CopyOnWriteArrayList<>();
		players.add(jugador1);
		
		tictactoegame.addPlayer(jugador1);
		verify(conexion1).sendEvent(eq(EventType.JOIN_GAME), eq(players));
		verify(conexion2).sendEvent(eq(EventType.JOIN_GAME), eq(players));
		
		players.add(jugador2);
		tictactoegame.addPlayer(jugador2);
		verify(conexion1, times(2)).sendEvent(eq(EventType.JOIN_GAME), eq(players));
		verify(conexion2, times(2)).sendEvent(eq(EventType.JOIN_GAME), eq(players));
		
		
		//Comprobamos los turnos
		
	}

}
