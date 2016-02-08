package edu.bsu.storygame;

import org.junit.Before;
import org.junit.Test;
import react.Value;
import react.ValueView;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class GameContextTest {

    private GameContext gc;

    @Before
    public void setUp() {
        gc = new GameContext();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testNotificationOfPhaseChange() {
        ValueView.Listener listener = mock(ValueView.Listener.class);
        gc.phase.update(Phase.MOVEMENT);
        gc.phase.connect(listener);
        gc.phase.update(Phase.ENCOUNTER);
        verify(listener).onChange(Phase.ENCOUNTER, Phase.MOVEMENT);
    }
}
