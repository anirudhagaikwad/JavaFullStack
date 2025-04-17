import {Component, signal, computed} from '@angular/core';
import {bootstrapApplication} from '@angular/platform-browser';

@Component({
  selector: 'app-root',
  template: `
    <h2>Cookie recipe</h2>

    <label>
      # of cookies:
      <input type="range" min="10" max="100" step="10" [value]="count()" (input)="update($event)" />
      {{ count() }}
    </label>

    <p>Butter: {{ butter() }} cup(s)</p>
    <p>Sugar: {{ sugar() }} cup(s)</p>
    <p>Flour: {{ flour() }} cup(s)</p>
  `,
styles: [
    `    host {
      display: block; 
      padding: 1rem;
      background: #f9f9f9;
      border-radius: 8px;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }
    h2 {  

      font-size: 1.5rem;
      margin-bottom: 1rem;
    }
    label {   

      display: block;
      margin-bottom: 1rem;
    }
    input[type="range"] { 
      width: 100%;
      margin-top: 0.5rem;
    }
    p { 
      margin: 0.5rem 0;
      font-size: 1rem;
    }
],
    ` 
})

export class CookieRecipe {
  count = signal(10);

  butter = computed(() => this.count() * 0.1);
  sugar = computed(() => this.count() * 0.05);
  flour = computed(() => this.count() * 0.2);

  update(event: Event) {
    const input = event.target as HTMLInputElement;
    this.count.set(parseInt(input.value));
  }
}


bootstrapApplication(CookieRecipe);
