/* tslint:disable no-unused-expression */
import { element, by, browser } from 'protractor';

import NavBarPage from '../../page-objects/navbar-page';
import SignInPage from '../../page-objects/signin-page';
import { waitUntilDisplayed } from '../../util/utils';

const expect = chai.expect;

describe('Administration', () => {
  let navBarPage: NavBarPage;
  let signInPage: SignInPage;

  before(async () => {
    await browser.get('/');
    navBarPage = new NavBarPage();
    signInPage = await navBarPage.getSignInPage();
    await signInPage.waitUntilDisplayed();
    await signInPage.username.sendKeys('admin');
    await signInPage.password.sendKeys('admin');
    await signInPage.loginButton.click();
    await signInPage.waitUntilHidden();

    await waitUntilDisplayed(navBarPage.adminMenu);
  });

  it('should load user management', async () => {
    await navBarPage.clickOnAdminMenuItem('user-management');
    const heading = element(by.id('user-management-page-heading'));
    await waitUntilDisplayed(heading);
    // Title should be equal to 'Users'
    expect(await heading.isPresent()).to.be.true;
  });

  it('should load metrics', async () => {
    await navBarPage.clickOnAdminMenuItem('jhi-metrics');
    const heading = element(by.id('metrics-page-heading'));
    await waitUntilDisplayed(heading);
    expect(await heading.getText()).not.to.be.empty;
  });

  it('should load health', async () => {
    await navBarPage.clickOnAdminMenuItem('jhi-health');
    const heading = element(by.id('health-page-heading'));
    await waitUntilDisplayed(heading);
    expect(await heading.getText()).not.to.be.empty;
  });

  it('should load configuration', async () => {
    await navBarPage.clickOnAdminMenuItem('jhi-configuration');
    const heading = element(by.id('configuration-page-heading'));
    await waitUntilDisplayed(heading);
    expect(await heading.getText()).not.to.be.empty;
  });

  it('should load audits', async () => {
    await navBarPage.clickOnAdminMenuItem('audits');
    const heading = element(by.id('audits-page-heading'));
    await waitUntilDisplayed(heading);
    expect(await heading.getText()).not.to.be.empty;
  });

  it('should load logs', async () => {
    await navBarPage.clickOnAdminMenuItem('logs');
    const heading = element(by.id('logs-page-heading'));
    await waitUntilDisplayed(heading);
    expect(await heading.getText()).not.to.be.empty;
  });

  after(async () => {
    await navBarPage.autoSignOut();
  });
});
