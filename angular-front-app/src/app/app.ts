import { Component, inject } from '@angular/core';
import { RouterOutlet, RouterLink, RouterLinkActive } from '@angular/router';

import { AppSettingsService } from './core/app-settings.service';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, RouterLink, RouterLinkActive],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  private readonly settings: AppSettingsService = inject(AppSettingsService);

  protected get gatewayUrl(): string {
    return this.settings.gatewayBaseUrl;
  }
}
