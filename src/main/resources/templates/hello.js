function Hello($scope, $http) {
    $http.get('/api/products').
        success(function(data) {
            $scope.products = {data};
        });
}