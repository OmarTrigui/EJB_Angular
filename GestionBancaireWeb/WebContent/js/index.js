var app = angular.module('test-app', ['ngMaterial', 'ngMdIcons', 'mdDataTable', 'ng-mfb']);

app.controller('AppCtrl', ['$window', '$scope', '$mdSidenav', '$mdDialog', '$http', '$mdToast', function ($window, $scope, $mdSidenav, $mdDialog, $http, $mdToast) {


    // INITIALISATION

    $scope.tableCardIsEnabled = true;
    $scope.tableIsSelectable = true;
    $scope.tableIsSortable = true;
    $scope.clients = 'Loading clients';
    $scope.accounts = 'Loading Accounts';
    $scope.allData = 'Loading all informations';

    var BASE_URL = $window.location.href;

    // ACCOUNT MANIPULATION

    $scope.saveAccount = function () {
        $http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";

        var fh = new FormHelper();
        fh.append("cin", $scope.user.cin);
        fh.append("solde", $scope.user.credit);

        $http({
            method: 'POST',
            url: BASE_URL + '/AjoutCbServlet?' + fh.data,
        }).then(function (response) {
            $mdDialog.hide();
            $mdToast.show($mdToast.simple().content(response.data).hideDelay(5000));
        }, function (response) {
        });
    }

    $scope.showAddAccount = function (ev) {
        $mdDialog.show({
            controller: DialogController,
            templateUrl: 'templates/account.tmpl.html',
            targetEvent: ev,
        })
            .then(function (answer) {
            }, function () {
            });
    };


    $scope.deleteAccountCallback = function (rows) {

        rows.forEach(function (rib) {

            $http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";

            var fh = new FormHelper();
            fh.append("rib", rib);

            $http({
                method: 'POST',
                url: BASE_URL + '/SupprimerCbServlet?' + fh.data,
            }).then(function (response) {
            }, function (response) {
            });
        });

        $mdToast.show($mdToast.simple().content(rows.length + ' account(s) has been removed').action('UNDO')
            .highlightAction(false));
    };


    // CLIENT MANIPULATION

    $scope.saveClient = function () {
        $http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";

        var fh = new FormHelper();
        fh.append("cin", $scope.user.cin);
        fh.append("firstName", $scope.user.firstName);
        fh.append("lastName", $scope.user.lastName);
        fh.append("address", $scope.user.address);

        $http({
            method: 'POST',
            url: BASE_URL + '/AjoutClientServlet?' + fh.data,
        }).then(function (response) {
            $mdDialog.hide();
            $mdToast.show($mdToast.simple().content(response.data));
        }, function (response) {
        });
    }

    $scope.deleteClientCallback = function (rows) {

        rows.forEach(function (cin) {

            $http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";

            var fh = new FormHelper();
            fh.append("cin", cin);

            $http({
                method: 'POST',
                url: BASE_URL + '/SupprimerClientServlet?' + fh.data,
            }).then(function (response) {
            }, function (response) {
            });
        });

        $mdToast.show($mdToast.simple().content(rows.length + ' client(s) has been removed').action('UNDO')
            .highlightAction(false));
    };

    $scope.showAddClient = function (ev) {

        $mdDialog.show({
            controller: DialogController,
            templateUrl: 'templates/client.tmpl.html',
            targetEvent: ev,
        })
            .then(function (answer) {
            }, function () {
            });
    };


    // POST QUERY HELPER

    function FormHelper() {
        this.data = "";

        this.append = function (name, val) {
            if (this.data.length > 0) {
                this.data += "&";
            }
            this.data += encodeURIComponent(name);
            this.data += "=";
            this.data += encodeURIComponent(val);
        }
    }


    // FLOATING ACTION BUTTON CONFIG 

    var vm = this;

    vm.menuState = 'closed';
    vm.loc = loc;
    vm.setMainAction = setMainAction;
    vm.mainAction = mainAction;

    vm.chosen = {
        effect: 'slidein-spring',
        position: 'br',
        method: 'click',
        action: 'fire'
    };

    vm.buttons = [
        {
            label: 'Create account',
            icon: 'ion-card',
            href: 'account'
        }
        , {
            label: 'Register Client',
            icon: 'ion-person-add',
            href: 'client'
        }
    ];

    function loc(href) {

        switch (href) {
            case 'client' :
                $scope.showAddClient();
                break;
            case 'account' :
                $scope.showAddAccount();
                break;
        }
    }

    function mainAction() {
    }

    function setMainAction() {
        if (vm.chosen.action === 'fire') {
            vm.mainAction = mainAction;
        } else {
            vm.mainAction = null;
        }
    }

    $scope.toggleSidenav = function (menuId) {
        $mdSidenav(menuId).toggle();
    };


    // DATA INIT REFRESH

    $scope.refreshAll = function () {
        $http({
            method: 'GET',
            url: BASE_URL + '/ListClientServlet'
        }).then(function (response) {
            $scope.clients = response.data;
        }, function (response) {
        });

        $http({
            method: 'GET',
            url: BASE_URL + '/ListCbServlet'
        }).then(function (response) {
            $scope.accounts = response.data;
        }, function (response) {
        });
    }

    $scope.refreshAll();


    // SIDE BAR CONFIGURATION

    $scope.menu = [
        {
            link: '',
            title: 'Dashboard',
            icon: 'dashboard'
        }
    ];

    $scope.admin = [
        {
            title: 'Settings',
            icon: 'settings'
        }
    ];

}]);

// DIALOG CONTROLLER

function DialogController($scope, $mdDialog) {
    $scope.hide = function () {
        $mdDialog.hide();
    };
    $scope.cancel = function () {
        $mdDialog.cancel();
    };
    $scope.answer = function (answer) {
        $mdDialog.hide(answer);
    };
};

// CONFIG

app.config(function ($mdThemingProvider) {
    var customBlueMap = $mdThemingProvider.extendPalette('green', {
        'contrastDefaultColor': 'light',
        'contrastDarkColors': ['50'],
        '50': 'ffffff'
    });
    $mdThemingProvider.definePalette('customBlue', customBlueMap);
    $mdThemingProvider.theme('default')
        .primaryPalette('customBlue', {
            'default': '500',
            'hue-1': '50'
        })
        .accentPalette('green');
    $mdThemingProvider.theme('input', 'default')
        .primaryPalette('grey')
});