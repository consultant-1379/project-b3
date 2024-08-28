/**
 * Component Landing_page is defined as
 * `<e-landing_page>`
 *
 * Imperatively create component
 * @example
 * let component = new Landing_page();
 *
 * Declaratively create component
 * @example
 * <e-landing_page></e-landing_page>
 *
 * @extends {LitComponent}
 */
import { definition } from '@eui/component';
import { LitComponent, html } from '@eui/lit-component';
import style from './landing_page.css';

/**
 * @property {Boolean} propOne - show active/inactive state.
 * @property {String} propTwo - shows the "Hello World" string.
 */
@definition('e-landing_page', {
  style,
  home: 'landing_page',
  props: {
    propOne: { attribute: true, type: Boolean },
    propTwo: { attribute: true, type: String, default: 'Hello World' },
  },
})
export default class Landing_page extends LitComponent {
  /**
   * Render the <e-landing_page> component. This function is called each time a
   * prop changes.
   */
  render() {
    return html`
    <table align="center" width=60%>
        <tr>
          <td align="center"><h1>Welcome to Ericsson Cloud Native Matrix Generation App</h1><td>
        </tr>
       <table>
    `;
  }
}

/**
 * Register the component as e-landing_page.
 * Registration can be done at a later time and with a different name
 */
Landing_page.register();
