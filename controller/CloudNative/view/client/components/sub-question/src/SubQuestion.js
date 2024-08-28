/**
 * Component SubQuestion is defined as
 * `<e-sub-question>`
 *
 * Imperatively create component
 * @example
 * let component = new SubQuestion();
 *
 * Declaratively create component
 * @example
 * <e-sub-question></e-sub-question>
 *
 * @extends {LitComponent}
 */
import { definition } from '@eui/component';
import { LitComponent, html } from '@eui/lit-component';
import style from './subQuestion.css';

/**
 * @property {Boolean} propOne - show active/inactive state.
 * @property {String} propTwo - shows the "Hello World" string.
 */
@definition('e-sub-question', {
  style,
  home: 'sub-question',
  props: {
    propOne: { attribute: true, type: Boolean },
    propTwo: { attribute: true, type: String, default: 'Hello World' },
    questions: {attribute: true, type: 'string'}
  },
})
export default class SubQuestion extends LitComponent {
  /**
   * Render the <e-sub-question> component. This function is called each time a
   * prop changes.
   */

  // didConnect(){
  //   fetch('http://localhost:8081/sub-questions')
  //   .then(function(response) {
  //     return response.json()
  //   }).then(function(json) {
  //     this.subQuestions = json
  //     console.log('Sub Questions: ', json)
  //   }.bind(this)).catch(function(ex) {
  //     console.log('parsing failed', ex)
  //   })
  // }


  render() {
    return html`<h2>${this.questions}</h2>`;
  }
}

/**
 * Register the component as e-sub-question.
 * Registration can be done at a later time and with a different name
 */
SubQuestion.register();
