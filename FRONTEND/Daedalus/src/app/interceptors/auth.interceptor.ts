import { Injectable } from '@angular/core';
import {
    HttpRequest,
    HttpHandler,
    HttpEvent,
    HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

    user: any

    constructor() { }

    intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {

        this.user = JSON.parse(localStorage.getItem("user")!);
        if (!this.user) return next.handle(request);

        const newreq = request.clone({
            headers: request.headers.set(
                "Authorization",
                `Bearer ${this.user.accessToken}`
            )
        })
        return next.handle(newreq);
    }
}
