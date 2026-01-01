import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { AppSettingsService } from './app-settings.service';

export const apiBaseUrlInterceptor: HttpInterceptorFn = (req, next) => {
  const settings = inject(AppSettingsService);
  const baseUrl = settings.gatewayBaseUrl;
  if (baseUrl) {
    const apiReq = req.clone({ url: `${baseUrl}${req.url}` });
    return next(apiReq);
  }
  return next(req);
};
