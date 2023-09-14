// src/app/auth.guard.ts
import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
import { StorageService } from './storage.service';

@Injectable({
  providedIn: 'root',
})
export class AuthGuard implements CanActivate {
  constructor(private router: Router, private storageService: StorageService) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): boolean {
    const userRole: any = this.storageService.getUser().role;
    if (!userRole) {
      this.router.navigate(['/login']);
      return false;
    }

    const requiredRole = route.data['requiredRole'];
    if (userRole.indexOf(requiredRole) === -1) {
      this.router.navigate(['/unauthorized']);
      return false;
    }

    // Allow access to the route
    return true;
  }
}
