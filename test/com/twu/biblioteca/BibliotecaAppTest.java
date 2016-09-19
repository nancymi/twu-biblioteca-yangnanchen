package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by ncyang on 9/13/16.
 */
public class BibliotecaAppTest {

    @Test
    public void when_start_application_print_welcome_message() throws Exception {
        BibliotecaApp bibliotecaApp = mock(BibliotecaApp.class);
        assertEquals(bibliotecaApp.welcome(), "welcome!");
    }
}