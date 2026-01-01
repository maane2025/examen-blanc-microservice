import { Injectable } from '@angular/core';

/**
 * Central place to configure the gateway URL.
 *
 * IMPORTANT: your gateway is running on 9090 (because 8080 is occupied).
 */
@Injectable({ providedIn: 'root' })
export class AppSettingsService {
  /**
   * Base URL of the API gateway. Leave empty to use same-origin.
   * For local dev, we default to http://localhost:9090.
   */
  readonly gatewayBaseUrl = 'http://localhost:9090';
}
