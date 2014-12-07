package org.bagab.greeter;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;

import static org.junit.Assert.assertEquals;

/**
 * Created by jvp on 11/29/14.
 */
@RunWith(Arquillian.class)
public class GreeterEJBTest {

    @Deployment()
    public static Archive<?> generateDefaultDeployment() {
        return ShrinkWrap.create(JavaArchive.class, "ejb-template.jar")
                .addPackage(GreeterEJB.class.getPackage());
    }

    @EJB
    private GreeterEJB greeterEJB;


    @Test
    public void testGreeter() throws Exception {
        String name = "World!";
        assertEquals("Hello " + name, greeterEJB.sayHello(name));
    }

    @Test
    public void testGreeter1() throws Exception {
        String name = "World!";
        assertEquals("Hello " + name, greeterEJB.sayHello(name));
    }
}
