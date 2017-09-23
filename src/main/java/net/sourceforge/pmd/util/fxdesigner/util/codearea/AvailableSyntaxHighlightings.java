/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.util.fxdesigner.util.codearea;

import java.util.Arrays;
import java.util.Optional;

import net.sourceforge.pmd.lang.Language;
import net.sourceforge.pmd.util.fxdesigner.util.codearea.syntaxhighlighting.JavaSyntaxHighlighter;

/**
 * @author Clément Fournier
 * @since 6.0.0
 */
public enum AvailableSyntaxHighlightings {
    JAVA("java", new SyntaxHighlightingComputer(new JavaSyntaxHighlighter()));


    private final String language;
    private final SyntaxHighlightingComputer computer;


    AvailableSyntaxHighlightings(String languageTerseName, SyntaxHighlightingComputer computer) {
        this.language = languageTerseName;
        this.computer = computer;
    }


    public static SyntaxHighlightingComputer getComputerForLanguage(Language language) {
        Optional<AvailableSyntaxHighlightings> found = Arrays.stream(AvailableSyntaxHighlightings.values())
                                                             .filter(e -> e.language.equals(language.getTerseName()))
                                                             .findFirst();
        if (found.isPresent()) {
            return found.get().computer;
        } else {
            return null;
        }

    }
}