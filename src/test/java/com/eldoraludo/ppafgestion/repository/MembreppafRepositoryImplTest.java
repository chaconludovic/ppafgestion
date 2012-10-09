/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/test/java/service/ServiceImplTest.e.vm.java
 */
package com.eldoraludo.ppafgestion.repository;

import static org.fest.assertions.Assertions.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import javax.persistence.NonUniqueResultException;
import javax.persistence.NoResultException;

import org.junit.Before;
import org.junit.Test;

import com.eldoraludo.ppafgestion.domain.Membreppaf;
import com.eldoraludo.ppafgestion.repository.MembreppafRepositoryImpl;
import com.eldoraludo.ppafgestion.dao.MembreppafDao;
import com.eldoraludo.ppafgestion.dao.support.SearchParameters;

/**
 * Unit test on MembreppafRepositoryImpl
 */
public class MembreppafRepositoryImplTest {

    private MembreppafRepositoryImpl membreppafRepositoryImpl;
    private MembreppafDao membreppafDao;

    @Before
    public void setUp() {
        // called before each test.
        membreppafRepositoryImpl = new MembreppafRepositoryImpl();
        membreppafDao = mock(MembreppafDao.class);
        membreppafRepositoryImpl.setMembreppafDao(membreppafDao);
    }

    @Test
    public void testFindUniqueOrNoneCaseNone() {
        Membreppaf none = null;

        when(membreppafDao.findUniqueOrNone(any(Membreppaf.class), any(SearchParameters.class))).thenReturn(none);

        Membreppaf result = membreppafRepositoryImpl.findUniqueOrNone(new Membreppaf());

        assertThat(result).isNull();
        verify(membreppafDao, times(1)).findUniqueOrNone(any(Membreppaf.class), any(SearchParameters.class));
    }

    @Test
    public void testFindUniqueOrNoneCaseUnique() {
        Membreppaf unique = new Membreppaf();

        when(membreppafDao.findUniqueOrNone(any(Membreppaf.class), any(SearchParameters.class))).thenReturn(unique);

        Membreppaf result = membreppafRepositoryImpl.findUniqueOrNone(new Membreppaf());

        assertThat(result).isNotNull();
        verify(membreppafDao, times(1)).findUniqueOrNone(any(Membreppaf.class), any(SearchParameters.class));
    }

    @SuppressWarnings("unchecked")
    @Test(expected = NonUniqueResultException.class)
    public void testFindUniqueOrNoneCaseMultiple() {
        when(membreppafDao.findUniqueOrNone(any(Membreppaf.class), any(SearchParameters.class))).thenThrow(NonUniqueResultException.class);

        membreppafRepositoryImpl.findUniqueOrNone(new Membreppaf());
    }

    @SuppressWarnings("unchecked")
    @Test(expected = NoResultException.class)
    public void testFindUniqueCaseNone() {
        when(membreppafDao.findUnique(any(Membreppaf.class), any(SearchParameters.class))).thenThrow(NoResultException.class);

        membreppafRepositoryImpl.findUnique(new Membreppaf());
    }

    @Test
    public void testFindUniqueCaseUnique() {
        Membreppaf unique = new Membreppaf();

        when(membreppafDao.findUnique(any(Membreppaf.class), any(SearchParameters.class))).thenReturn(unique);

        Membreppaf result = membreppafRepositoryImpl.findUnique(new Membreppaf());

        assertThat(result).isNotNull();
        verify(membreppafDao, times(1)).findUnique(any(Membreppaf.class), any(SearchParameters.class));
    }

    @SuppressWarnings("unchecked")
    @Test(expected = NonUniqueResultException.class)
    public void testFindUniqueCaseMultiple() {
        when(membreppafDao.findUnique(any(Membreppaf.class), any(SearchParameters.class))).thenThrow(NonUniqueResultException.class);

        membreppafRepositoryImpl.findUnique(new Membreppaf());
    }
}