package NameChecker;

import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.ElementScanner8;
import java.util.concurrent.locks.ReentrantLock;

public class NameChecker {
    private final Messager messager;

    NameCheckerScanner nameCheckerScanner = new NameCheckerScanner();

    NameChecker(ProcessingEnvironment processingEnv) {
        this.messager = processingEnv.getMessager();
    }

    public void checkNames(Element element) {
        nameCheckerScanner.scan(element);
    }


    private class NameCheckerScanner extends ElementScanner8<Void, Void> {
        public Void visitType(TypeElement e, Void p) {
            scan(e.getTypeParameters(), p);
            //checkCamelCase(e, true);
            super.visitType(e, p);
            return null;
        }
    }
}
