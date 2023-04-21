import { Directive, ElementRef, HostListener, Input } from '@angular/core';

@Directive({
    selector: '[appHighlight]'
})
export class HighlightDirective {

    @Input() appHighlight = ""

    constructor(private element: ElementRef) {
    }

    @HostListener("mouseenter") onMouseEnter() {
        this.cambiaColore(this.appHighlight)
    }

    @HostListener("mouseleave") onMouseLeave() {
        this.cambiaColore("transparent")
    }

    cambiaColore(colore: string) {
        this.element.nativeElement.style.backgroundColor = colore
    }

}
