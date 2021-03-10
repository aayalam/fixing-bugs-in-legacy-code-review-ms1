package com.assetco.hotspots.optimization;

import com.assetco.search.results.Asset;
import com.assetco.search.results.AssetVendor;
import com.assetco.search.results.AssetVendorRelationshipLevel;
import com.assetco.search.results.HotspotKey;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BugsTest {

    @Test
    void precedingPartnerWithLongTrailingAssetsDoesNotWin() {

        AssetVendor partnerVendor = makeVendor(AssetVendorRelationshipLevel.Partner);
        Asset missing = givenAssetInResultsWithVendor(partnerVendor);

        AssetVendor anotherPartnerVendor = makeVendor(AssetVendorRelationshipLevel.Partner);
        Asset disruptingAsset = givenAssetInResultsWithVendor(anotherPartnerVendor);

        List<Asset> expected = makeConsecutiveAssetItems(partnerVendor);

        whenOptimize();

        thenHotspotDoesNotHave(HotspotKey.Showcase, missing);

        thenHotspotHasExactly(HotspotKey.Showcase, expected);

    }

    private void thenHotspotHasExactly(HotspotKey showcase, List<Asset> expected) {
    }

    private void thenHotspotDoesNotHave(HotspotKey showcase, Asset missing) {
    }

    private void whenOptimize() {
    }

    private List<Asset> makeConsecutiveAssetItems(AssetVendor partnerVendor) {
        List<Asset> assets = new ArrayList<>();

        for (int k = 0; k < 4; k++) {
            assets.add(givenAssetInResultsWithVendor(partnerVendor));
        }

        return assets;
    }

    private Asset givenAssetInResultsWithVendor(AssetVendor partnerVendor) {
        return null;
    }

    private AssetVendor makeVendor(AssetVendorRelationshipLevel partner) {
        return null;
    }

}
